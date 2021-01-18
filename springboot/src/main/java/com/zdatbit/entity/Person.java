package com.zdatbit.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class Person {

    @Value("zhangsan")
    private String name;
    @Value("18")
    private int age;
}
