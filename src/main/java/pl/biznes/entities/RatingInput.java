package pl.biznes.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

public class RatingInput {
    @Getter
    @Setter
    @Id
    private String userId;

    @Getter
    @Setter
    @Id
    private long productId;

    @Getter
    @Setter
    private float rating;
}
