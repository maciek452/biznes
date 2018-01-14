package pl.apoeldevelopers.bizneselektroniczny.entities;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */


@EqualsAndHashCode
public class UserRatingId implements Serializable {

    protected long userId;
    protected long productId;

    public UserRatingId(){}

    public UserRatingId(long userId, long productId){
        this.userId = userId;
        this.productId = productId;
    }
}
