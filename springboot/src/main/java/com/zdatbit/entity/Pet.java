package com.zdatbit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private String name;
    private int age;


    @PostConstruct
    public void init(){
        System.out.println("============init=============");
    }

    @PreDestroy
    public void after(){
        System.out.println("===============after===============");
    }
}
