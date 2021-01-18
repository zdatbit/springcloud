package com.zdatbit.config;

import com.zdatbit.conditional.LinuxCondition;
import com.zdatbit.entity.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.zdatbit")
@Configuration
public class Config {

    @Conditional(value = LinuxCondition.class)
    @Bean(initMethod = "init",destroyMethod = "after")
    public Pet pet(){
        return new Pet();
    }


}
