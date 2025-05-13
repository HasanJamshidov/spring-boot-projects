package com.jamshidow.calculator.controller;

import com.jamshidow.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String showForm(){
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double number1,
            @RequestParam double number2,
            @RequestParam String operation,
            Model model
    ){
        double result = calculatorService.calculate(number1, number2, operation);
        model.addAttribute("result", result);
        return "index";
    }
}
