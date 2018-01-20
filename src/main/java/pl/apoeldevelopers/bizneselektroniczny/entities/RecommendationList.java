package pl.apoeldevelopers.bizneselektroniczny.entities;

import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.GET;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
public class RecommendationList {
    @Getter @Setter
    private List<Recommendation> products;

    public RecommendationList(){
        products = new ArrayList<>();
    }

    public void add(Recommendation reco){
        products.add(reco);
    }
}
