package pl.apoeldevelopers.bizneselektroniczny.utilities;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
public class Recommender {
    @Autowired
    DataSource dataSource;


    public void getRecommendation() throws TasteException {
        DataModel dm = new MySQLJDBCDataModel(dataSource, "user_rating", "user_id", "product_id", "rating", null);

        ItemSimilarity sim = new LogLikelihoodSimilarity(dm);

        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);

        int x = 1;
        for(LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext();){
            long itemId = items.nextLong();
            List<RecommendedItem>recommendedItems = recommender.mostSimilarItems(itemId, 5);

            for(RecommendedItem recommendation : recommendedItems){
                System.out.println(itemId + ", " + recommendation.getItemID() + "," + recommendation.getValue());
            }
            x++;
            if(x>10) break;;
        }

    }
}
