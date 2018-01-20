package pl.biznes.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
