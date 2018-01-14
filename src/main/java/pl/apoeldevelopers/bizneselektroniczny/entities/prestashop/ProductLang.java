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
@Table(name = "ps_product_lang")
public class ProductLang {
    @Id
    @Column(name = "id_product")
    @Getter @Setter
    private long id;

    @Column(name = "link_rewrite")
    @Getter @Setter
    private String link;

    @Column(name = "name")
    @Getter @Setter
    private String name;
}
