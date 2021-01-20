package com.zdatbit.apect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class HelloAspect {


    @Pointcut("execution(public String com.zdatbit.apect.HelloWorld.*(..))")
    public void pointCut(){

    }

    /**
     * JoinPoint从容器中拿，可以获取目标方法的参数
     * @param joinPoint
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println("log start"+args);
    }

    @After("pointCut()")
    public void logEnd(){
        System.out.println("log end");
    }

    /**
     * 用returning来接收处理的结果
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("log return, the result is="+result);
    }


    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("log exception");
    }
}
