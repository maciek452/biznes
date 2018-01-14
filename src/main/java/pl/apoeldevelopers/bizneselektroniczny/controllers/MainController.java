package pl.apoeldevelopers.bizneselektroniczny.controllers;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.apoeldevelopers.bizneselektroniczny.entities.RatingInput;
import pl.apoeldevelopers.bizneselektroniczny.entities.RecommendationList;
import pl.apoeldevelopers.bizneselektroniczny.entities.prestashop.Product;
import pl.apoeldevelopers.bizneselektroniczny.utilities.DatabaseManager;
import pl.apoeldevelopers.bizneselektroniczny.utilities.Recommender;

@RestController
public class MainController {

    @Autowired
    private RecommendationList recommendationList;

    @Autowired
    private DatabaseManager db;

    @Autowired
    private Recommender recommender;

    @GetMapping("/test")
    public Product getMyObj(){
        return db.getProduct(1);
    }

    //@RequestBody(required = false) UserRating input
    @PostMapping("/add")
    public ResponseEntity<?> test(@RequestBody(required = true) RatingInput input){
        db.addUserRating(input);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public RecommendationList getRecommendations(@PathVariable("id") int id ){
        RecommendationList list;
        try {
            list = recommender.getRecommendation(id);
        } catch (TasteException e) {
            e.printStackTrace();
            list = new RecommendationList();
        }
        return list;
    }
}
