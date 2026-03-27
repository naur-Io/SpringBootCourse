package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new IllegalArgumentException("Invalid input");
        }

        return Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
    }

    private boolean isNumeric(String numberOne) {
        if(numberOne == null || numberOne.isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        try {
            Double.parseDouble(numberOne);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
