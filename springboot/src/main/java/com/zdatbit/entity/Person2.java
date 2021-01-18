package com.zdatbit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person2 {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

}
