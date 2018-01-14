package pl.apoeldevelopers.bizneselektroniczny.utilities;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import pl.apoeldevelopers.bizneselektroniczny.entities.Recommendation;
import pl.apoeldevelopers.bizneselektroniczny.entities.RecommendationList;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
public class Recommender {

    private DataSource dataSource;
    private DatabaseManager db;

    public Recommender(DataSource dataSource, DatabaseManager db){
        this.dataSource = dataSource;
        this.db = db;
    }

    public RecommendationList getRecommendation(int itemId) throws TasteException {
        DataModel dm = new ReloadFromJDBCDataModel(new MySQLJDBCDataModel(dataSource, "user_rating", "user_id", "product_id", "rating", null));

        ItemSimilarity sim = new LogLikelihoodSimilarity(dm);

        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);

        List<RecommendedItem>recommendedItems = recommender.mostSimilarItems(itemId, 4);

        RecommendationList list = new RecommendationList();
        for(RecommendedItem recommendation : recommendedItems){
            list.add(db.getRecommendation(recommendation.getItemID()));
            //System.out.println(itemId + ", " + recommendation.getItemID() + "," + recommendation.getValue());
        }

        return list;
    }
}

