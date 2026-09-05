package com.pefonseca.rest.with.spring.boot.and.java.controller;

import com.pefonseca.rest.with.spring.boot.and.java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    // http://localhost:8080/math/substraction/3/5
    @RequestMapping(value = "/substraction/{numberOne}/{numberTwo}")
    public Double substraction(@PathVariable(value = "numberOne") String numberOne,
                               @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/multiplication/3/5
    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable(value = "numberOne") String numberOne,
                                 @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/division/3/5
    @RequestMapping(value = "/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    // http://localhost:8080/math/mean/3/5
    @RequestMapping(value = "/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);

        return sum / 2;
    }

    // http://localhost:8080/math/squareRoot/3/5
    @RequestMapping(value = "/squareRoot/{number}")
    public Double squareRoot(@PathVariable(value = "number") String number) {
        if(!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");

        double convertedNumber = convertToDouble(number);

        if(convertedNumber < 0)throw new UnsupportedMathOperationException("It is not possible to calculate the square root of a negative number!");

        return Math.sqrt(convertedNumber);
    }

}
