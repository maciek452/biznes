package pl.biznes.entities.prestashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
