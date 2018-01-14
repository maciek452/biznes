package pl.apoeldevelopers.bizneselektroniczny.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
@Entity
public class UserIdMap {
    @Getter
    @Setter
    private String sid;

    @Getter
    @Setter
    @Id@GeneratedValue
    private long lid;

}
