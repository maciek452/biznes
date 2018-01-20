package pl.biznes.entities.prestashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
