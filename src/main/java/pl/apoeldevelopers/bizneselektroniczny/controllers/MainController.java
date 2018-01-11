package pl.apoeldevelopers.bizneselektroniczny.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.apoeldevelopers.bizneselektroniczny.MyObj;

@RestController
public class MainController {

    @GetMapping("/")
    public MyObj getMyObj(){
        MyObj myObj = new MyObj();
        myObj.setMessage("witaj");

        return myObj;
    }
}
