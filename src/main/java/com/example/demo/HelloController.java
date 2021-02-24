package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/math/pi")
    public String getPi() {
        return "3.141592653589793";
    }

    @GetMapping("/animals")
    public String getAnimals(@RequestParam (defaultValue = "dog") String animal,
                             @RequestParam (defaultValue = "88") String age) {
        return animal + "s are the best when they are " + age;
    }

    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getRectangleValue(@PathVariable int length,
                                    @PathVariable int width,
                                    @PathVariable int height) {
        int result = (length*width*height);

        return String.format("The volume of a %dx%dx%d rectangle is " + result, length, width, height);
    }

    @GetMapping("/cookie")
    public String accessCookieInformation(@CookieValue(name = "key") String value){
        return "This is our cookie: " + value;
    }

}