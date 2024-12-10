package com.amadeus.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect // AOP类
public class TimeAspect {

    // 抽取切入点表达式，需要在其他类中复用，需要改为public
//    @Pointcut("execution(* com.amadeus.service.*.*(..))")
    // 使用注解的方式匹配切入点方法
    @Pointcut("@annotation(com.amadeus.anno.MyLog)")
    public void pt(){};

//    @Around("execution(* com.amadeus.service.*.*(..))") // 切入点表达式
    @Around("pt()") // 抽取的切入点表达式，可复用
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // 执行原方法

        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature()+"方法执行耗时：{}ms", end - begin);

        return result;
    }
}
