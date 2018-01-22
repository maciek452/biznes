package pl.biznes.utilities;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
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

        //ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
        UserSimilarity userSimilarity = new PearsonCorrelationSimilarity(model);

        System.out.println("UserSimilarity: " + userSimilarity.);

        UserNeighborhood neighborhood =
                new ThresholdUserNeighborhood(0.1, similarity, model);
        System.out.println("UserNeighborhood: " + neighborhood.toString());

        //GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);

        GenericUserBasedRecommender recommender =
                new GenericUserBasedRecommender(model, neighborhood, userSimilarity);

        System.out.println("GenericUserBasedRecommender: " + recommender.toString());
        //CachingRecommender cachingRecommender = new CachingRecommender(recommender);

        //List<RecommendedItem>recommendedItems = recommender.mostSimilarItems(itemId, 4);
        List<RecommendedItem> recommendations =
                recommender.recommend(userId, 4);
        System.out.println("userId: " + userId);
        System.out.println("recommendations: " + recommendations.toString());

        List<ScorpionRecommendation> list = new ArrayList<>();
        for(RecommendedItem recommendation : recommendations){
            list.add(db.getRecommendation(recommendation.getItemID()));
        }

        System.out.println("list: " + list.toString());
        return list;
    }
}

