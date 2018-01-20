package pl.apoeldevelopers.bizneselektroniczny.entities;

import lombok.Getter;
import lombok.Setter;

public class ScorpionRecommendation {
    @Getter
    @Setter
    private long id;

    public ScorpionRecommendation(long id){
        this.id = id;
    }
}

