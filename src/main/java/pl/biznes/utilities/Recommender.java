package pl.biznes.utilities;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import pl.biznes.entities.ScorpionRecommendation;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Recommender {

    private DataSource dataSource;
    private DatabaseManager db;

    public Recommender(DataSource dataSource, DatabaseManager db){
        this.dataSource = dataSource;
        this.db = db;
    }

    public List<ScorpionRecommendation> getRecommendation(int userId) throws TasteException {
        DataModel model = new ReloadFromJDBCDataModel(new MySQLJDBCDataModel(dataSource, "ps_product_comment", "id_customer", "id_product", "grade", null));

        UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(model);

        UserNeighborhood neighborhood =
                new ThresholdUserNeighborhood(0.5, userSimilarity, model);
        //tutaj wypisuję sąsiadów danego usera
        for(Long user : neighborhood.getUserNeighborhood(userId)){
            System.out.println("UserNeighborhood for user: " + user);
        }

        GenericUserBasedRecommender recommender =
                new GenericUserBasedRecommender(model, neighborhood, userSimilarity);

        //tutaj wypisuję preferencje danego usera
        for(int i = 1; i < 400; i++){
            if(recommender.estimatePreference(userId, i)!= Float.NaN)
                System.out.println("Preference for item "+ i +": " + recommender.estimatePreference(userId, i));
        }

        List<RecommendedItem> recommendations =
                recommender.recommend(userId, 4);
        System.out.println("userId: " + userId);
        //a tu rekomendacje
        System.out.println("recommendations: " + recommendations.toString());
        //jak nie ma sąsiadów, to nie ma rekomendacji

        List<ScorpionRecommendation> list = new ArrayList<>();
        for(RecommendedItem recommendation : recommendations){
            list.add(db.getRecommendation(recommendation.getItemID()));
        }

        System.out.println("list: " + list.toString());
        return list;
    }
}

