package pl.biznes.entities;

import lombok.Getter;
import lombok.Setter;

public class Recommendation {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private float price;

    @Getter @Setter
    private String url;

    @Getter @Setter
    private String imageUrl;

    public Recommendation(){}
    public Recommendation(long id, String name, float price, String url, String imageUrl){
        this.id = id;
        this.name = name;
        this.price = price;
        this.url = url;
        this.imageUrl = imageUrl;
    }
}
