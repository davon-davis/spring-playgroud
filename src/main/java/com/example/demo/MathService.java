package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MathService {


    @GetMapping("/math/calculate")
    public String getMathCalculate(Calculate cal) {
        String answer = null;

        if(cal.getOperation().equals("add")){
            answer = cal.doAdd();
        }else if(cal.getOperation().equals("subtract")){
            answer = cal.doSub();
        }else if(cal.getOperation().equals("multiply")){
            answer = cal.doMultiply();
        }else if(cal.getOperation().equals("divide")){
            answer = cal.doDivide();
        }else{
            answer = cal.doAdd();
        }

        return answer;
    }

    @PostMapping("/math/sum")
    public String postingSum(Calculate cal) {
        return cal.sumList();
    }

    @PostMapping("/math/area")
    public String postingArea(Calculate cal) {
        return cal.areaValid();
    }





























}
