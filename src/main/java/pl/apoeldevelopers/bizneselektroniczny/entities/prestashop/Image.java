package pl.apoeldevelopers.bizneselektroniczny.entities.prestashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
@Entity
@Table(name = "ps_image")
public class Image {

    @Column(name = "id_image")
    @Getter @Setter
    private Long id;

    @Id
    @Column(name = "id_product")
    @Getter @Setter
    private Long productId;

}
