package com.zdatbit.zuul.producer2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return "hello "+name+", producer2 is ready";
    }
}
