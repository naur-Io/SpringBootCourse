package com.example.demo.controllers;

import com.example.demo.expections.UnsupportedMathOperationException;
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
            throw new UnsupportedMathOperationException("Set a numeric value!");
        }

        return Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
    }

    private boolean isNumeric(String numberOne) {
        if(numberOne == null || numberOne.isEmpty()){
            throw new UnsupportedMathOperationException("Input cannot be null or empty");
        }
        try {
            Double.parseDouble(numberOne);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
