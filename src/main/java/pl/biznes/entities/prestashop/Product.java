package pl.biznes.entities.prestashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ps_product")
public class Product {

    @Id
    @Column(name = "id_product")
    @Getter @Setter
    private long id;

    @Column(name = "cache_default_attribute")
    @Getter @Setter
    private int cache;

    @Column(name = "price")
    @Getter @Setter
    private float price;

}
