package com.example.demo.controllers;

import com.example.demo.expections.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

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


    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Set a numeric value!");
        }

        return Double.parseDouble(numberOne) - Double.parseDouble(numberTwo);
    }


    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Set a numeric value!");
        }

        return Double.parseDouble(numberOne) * Double.parseDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Set a numeric value!");
        }

        if(Double.parseDouble(numberTwo) == 0){
            throw new UnsupportedMathOperationException("Division by zero is not allowed!");
        }

        return Double.parseDouble(numberOne) / Double.parseDouble(numberTwo);
    }

    @RequestMapping("/square/{numberOne}")
    public Double square(
            @PathVariable("numberOne") String numberOne
    ){
        if(!isNumeric(numberOne)){
            throw new UnsupportedMathOperationException("Set a numeric value!");
        }

        return Double.parseDouble(numberOne) * Double.parseDouble(numberOne);
    }


}
