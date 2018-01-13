package pl.apoeldevelopers.bizneselektroniczny.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.apoeldevelopers.bizneselektroniczny.MyObj;
import pl.apoeldevelopers.bizneselektroniczny.entity.UserRating;

@RestController
public class MainController {

    @GetMapping("/test")
    public MyObj getMyObj(){
        MyObj myObj = new MyObj();
        myObj.setMessage("Ostateczna próba");

        return myObj;
    }

    @PostMapping("/test")
    ResponseEntity<?> test(@RequestBody UserRating input){
        if(input.getLorem() == "ipsum")
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }
}
