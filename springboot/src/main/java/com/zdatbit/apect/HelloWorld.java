package com.zdatbit.apect;

import org.springframework.stereotype.Service;

@Service
public class HelloWorld {

    public String run(String str){
        System.out.println("hello world");
        return str;
    }
}
