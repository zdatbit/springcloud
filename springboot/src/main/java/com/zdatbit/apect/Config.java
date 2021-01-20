package com.zdatbit.apect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class Config {

    @Bean
    public HelloWorld helloWorld(){
        return new HelloWorld();
    }


    @Bean
    public HelloAspect helloAspect(){
        return new HelloAspect();
    }
}
