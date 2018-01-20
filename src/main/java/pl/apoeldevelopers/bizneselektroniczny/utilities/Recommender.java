package pl.apoeldevelopers.bizneselektroniczny.utilities;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.ReloadFromJDBCDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import pl.apoeldevelopers.bizneselektroniczny.entities.RecommendationList;
import pl.apoeldevelopers.bizneselektroniczny.entities.ScorpionRecommendation;

import javax.sql.DataSource;
import java.util.ArrayList;
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

    public List<ScorpionRecommendation> getRecommendation(int itemId) throws TasteException {
        DataModel dm = new ReloadFromJDBCDataModel(new MySQLJDBCDataModel(dataSource, "ps_product_comment", "id_customer", "id_product", "grade", null));

        ItemSimilarity sim = new LogLikelihoodSimilarity(dm);

        GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);

        List<RecommendedItem>recommendedItems = recommender.mostSimilarItems(itemId, 4);

        List<ScorpionRecommendation> list = new ArrayList<>();
        for(RecommendedItem recommendation : recommendedItems){
            list.add(new ScorpionRecommendation(recommendation.getItemID()));
            //System.out.println(itemId + ", " + recommendation.getItemID() + "," + recommendation.getValue());
        }

        return list;
    }
}

