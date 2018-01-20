package pl.biznes.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

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
