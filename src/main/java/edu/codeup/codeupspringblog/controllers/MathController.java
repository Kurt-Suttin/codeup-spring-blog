package edu.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addNumbers(@PathVariable int num1, @PathVariable int num2) {
        int sum = num1 + num2;
        return String.format("%s + %s = %s", num1, num2, sum);
    }
    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public  String  subtractNumbers(@PathVariable int num1 , @PathVariable int num2){
        int sum = num2 - num1;
        return String.format("%s - %s = %s", num2, num1, sum);
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyNumbers(@PathVariable int num1, @PathVariable int num2) {
        int sum = num1 * num2;
        return String.format("%s * %s = %s", num1, num2, sum);
    }
    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divideNumbers(@PathVariable double num1, @PathVariable double num2) {
        double sum = num1 / num2;
        return String.format("%s / %s = %s", num1, num2, sum);
    }

}
