package pl.apoeldevelopers.bizneselektroniczny.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.ws.rs.GET;

/**
 * Created by Jakub Michałowski on 13.01.2018.
 * All rights reserved.
 */
@Entity
public class UserRating {

    @Getter
    @Setter
    private String lorem;

    @Getter
    @Setter
    private long name;

}
