package pl.biznes.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserIdMap {
    @Getter
    @Setter
    private String sid;

    @Getter
    @Setter
    @Id@GeneratedValue
    private long lid;

    public UserIdMap(){}

    public UserIdMap(String sid){
        this.sid = sid;
    }

}
