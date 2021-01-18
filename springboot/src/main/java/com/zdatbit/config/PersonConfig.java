package com.zdatbit.config;

import com.zdatbit.entity.Person;
import com.zdatbit.entity.Person2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/person.properties")
public class PersonConfig {

    @Bean
    public Person person(){
        return new Person();
    }

    @Bean
    public Person2 person2(){
        return new Person2();
    }
}
