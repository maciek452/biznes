package pl.apoeldevelopers.bizneselektroniczny.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.apoeldevelopers.bizneselektroniczny.MyObj;
import pl.apoeldevelopers.bizneselektroniczny.entities.RecoList;
import pl.apoeldevelopers.bizneselektroniczny.entities.Recommendation;
import pl.apoeldevelopers.bizneselektroniczny.entities.UserRating;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    RecoList recoList;

    @GetMapping("/test")
    public MyObj getMyObj(){
        MyObj myObj = new MyObj();
        myObj.setMessage("Ostateczna próba");

        return myObj;
    }

    //@RequestBody(required = false) UserRating input
    @PostMapping("/test")
    public ResponseEntity<?> test(){
//        if(input.getProductId() == 1){
//            return ResponseEntity.ok().build();
//        }
//        else{
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get")
    public RecoList getRecommendations( ){
        return recoList;
    }
}
