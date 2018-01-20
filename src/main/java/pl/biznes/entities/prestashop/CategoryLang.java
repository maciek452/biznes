package pl.biznes.entities.prestashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ps_category_lang")
public class CategoryLang {
    @Id
    @Column(name = "id_category")
    @Getter
    @Setter
    private Long id;

    @Column(name = "link_rewrite")
    @Getter @Setter
    private String link;
}
