package pl.biznes.controllers;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.biznes.entities.RatingInput;
import pl.biznes.entities.ScorpionRecommendation;
import pl.biznes.utilities.DatabaseManager;
import pl.biznes.utilities.Recommender;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private DatabaseManager db;

    @Autowired
    private Recommender recommender;

    @PostMapping("/add")
    public ResponseEntity<?> test(@RequestBody(required = true) RatingInput input){
        db.addUserRating(input);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public List<ScorpionRecommendation> getRecommendations(@PathVariable("id") int id ){
        List<ScorpionRecommendation> list;
        try {
            list = recommender.getRecommendation(id);
        } catch (TasteException e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }
}
