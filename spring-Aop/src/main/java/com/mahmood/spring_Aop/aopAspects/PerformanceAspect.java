package com.mahmood.spring_Aop.aopAspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class PerformanceAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Around("execution(* com.mahmood.spring_Aop.business.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startSysTime = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long stopSysTime = System.currentTimeMillis();

        long time = stopSysTime - startSysTime;

        logger.info("The function {} took {}",
                proceedingJoinPoint,
                time);

        return proceed;
    }
}
