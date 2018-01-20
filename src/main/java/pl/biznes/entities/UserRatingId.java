package pl.biznes.entities;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
