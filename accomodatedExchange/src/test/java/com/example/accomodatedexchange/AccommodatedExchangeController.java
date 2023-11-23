package com.example.accomodatedexchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class AccommodatedExchangeController {

    @GetMapping("world")
    public String Accommodated(){
        return "hello";
    }

}
