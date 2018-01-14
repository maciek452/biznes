package pl.apoeldevelopers.bizneselektroniczny.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.apoeldevelopers.bizneselektroniczny.database.repositories.*;
import pl.apoeldevelopers.bizneselektroniczny.entities.RatingInput;
import pl.apoeldevelopers.bizneselektroniczny.entities.Recommendation;
import pl.apoeldevelopers.bizneselektroniczny.entities.UserIdMap;
import pl.apoeldevelopers.bizneselektroniczny.entities.UserRating;
import pl.apoeldevelopers.bizneselektroniczny.entities.prestashop.*;

import java.util.List;

/**
 * Created by Jakub Michałowski on 14.01.2018.
 * All rights reserved.
 */
@Service
public class DatabaseManager {
    @Autowired
    RatingRepo ratingRepo;
    @Autowired
    MapRepo mapRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductLangRepo productLangRepo;
    @Autowired
    ImageRepo imageRepo;
    @Autowired
    CategoryLangRepo categoryLangRepo;
    @Autowired
    CategoryProductRepo categoryProductRepo;

    public void addUserRating(RatingInput ratingInput){
        UserIdMap userIdMap = new UserIdMap(ratingInput.getUserId());
        mapRepo.save(userIdMap);
        UserRating userRating = new UserRating(userIdMap.getLid(), ratingInput.getProductId(), ratingInput.getRating());
        ratingRepo.save(userRating);
    }

    public Product getProduct(int id){
        return productRepo.findOne(Integer.toUnsignedLong(id));
    }

    public Recommendation getRecommendation(Long id){

        Product product = productRepo.findOne(id);
        ProductLang productLang = productLangRepo.findOne(id);
        Image image = imageRepo.findOne(id);
        List<CategoryProduct> list = categoryProductRepo.findCategoryProductByProductId(id);
        CategoryProduct categoryProduct = list.get(0);
        CategoryLang categoryLang = categoryLangRepo.findOne(categoryProduct.getCategoryId());

        String cache;
        if(product.getCache()!=0)
            cache = "-" + Integer.toString(product.getCache()) + "-";
        else
            cache = "-";
        String name = productLang.getName();
        float price = product.getPrice();
        price = price - (price*0.23f);
        String url = "http://172.20.83.41/" + categoryLang.getLink() + "/" + id + cache + productLang.getLink() + ".html";
        String imageUrl = "http://172.20.83.41/" + image.getId() + "-home_default/" + productLang.getLink() + ".jpg";
        Recommendation recommendation = new Recommendation(id, name, price, url, imageUrl);

        return recommendation;
    }


}
