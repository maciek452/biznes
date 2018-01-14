package pl.apoeldevelopers.bizneselektroniczny.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
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
