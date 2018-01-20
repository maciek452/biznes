package pl.apoeldevelopers.bizneselektroniczny.entities;

import lombok.Getter;
import lombok.Setter;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Jakub Michałowski on 13.01.2018.
 * All rights reserved.
 */
@Entity
@IdClass(UserRatingId.class)
public class UserRating {

    @Getter
    @Setter
    @Id
    private long userId;

    @Getter
    @Setter
    @Id
    private long productId;

    @Getter
    @Setter
    private float rating;

    public UserRating(){}

    public UserRating(long userId, long productId, float rating){
        this.userId = userId;
        this.productId = productId;
        this.rating = rating;
    }

}
