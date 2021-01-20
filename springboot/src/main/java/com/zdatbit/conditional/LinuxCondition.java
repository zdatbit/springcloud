package com.zdatbit.conditional;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

    /**
     *
     * @param conditionContext          判断条件能使用的上下文信息（环境）
     * @param annotatedTypeMetadata     注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        //环境
        Environment environment = conditionContext.getEnvironment();

        //所有的bean都在这定义，也能手动注册
        BeanDefinitionRegistry registry = conditionContext.getRegistry();
        return true;
    }
}
