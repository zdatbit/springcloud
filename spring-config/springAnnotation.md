### @Configuration
表明这是一个配置类，跟spring里面的xml是一样的作用
```java
@Configuration
public class Config{
    
}
```

### @Bean
配合@Configuration使用，将类注入到spring容器中，spring容器中的名默认是方法名，
可以通过配置@Bean里的name或者value属性改变名称
```java
@Configuraiton
public class Config{
    
    @Bean(name="pet")
    public Pet pet(){
        return new Pet();
    }
}
```
### @Import
引入第三方类的时候，可以用@Import方法将该类注入spring容器，需要配合@Configuration使用,  
在容器中的name是全限定名
```java
@Configuration
@Import(ThirdClass.class)
public class Config{
    
}
```

### @ImportSource
引入类似spring中xml里的配置文件时，可以使用@ImportSource
````java
@Configuration
@ImportSource("classpath:/bean.xml")
public class Config {
    
}
````

### @Conditional
按照一定的条件进行判断，如果满足条件，则在容器中注册。springboot中大量使用该注解
需要实现一个Condition接口
```java
@Configuration
public class Config{
    
    @Conditional(value=LinuxContion.class)
    public Pet pet(){
        return new Pet();
    }
}

public class LinuxCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return false;
    }
}
```

### bean初始化
有两种常用的方法可以对bean进行初始化
1. 在@Bean注解里有initMethod和destoryMethod
```java
@ComponentScan("com.zdatbit")
@Configuration
public class Config {

    @Conditional(value = LinuxCondition.class)
    @Bean(initMethod = "init",destroyMethod = "after")
    public Pet pet(){
        return new Pet();
    }


}
```

2. @PostConstruct和 @PreDestroy方法
```java
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
```


### beanPostProcessor
在初始化前后做一些工作，需要实现BeanPostProcessor接口，实现的类需要注入到spring容器中。
实现的后置处理器对所有类生效
```java
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之前。。。。。。。。。。。。。。。。。。。。。。。");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之后...................................");
        return bean;
    }
}

```

### 属性赋值
1. @Value为对象赋值
```java
@Data
public class Person {

    @Value("zhangsan")
    private String name;
    @Value("18")
    private int age;
}
```

2. @PropertySource引入外部配置
```java
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

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person2 {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

}
```
另外说明，属性赋值引入外部文件时如果用的是@PropertySource只能用property文件
### @ConfigurationProperties 配置绑定
todo 
