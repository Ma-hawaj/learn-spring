package com.mahmood.spring_Aop.aopAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // @Pointcut -> when
    // the following will interrupt every method call in PACKAGE
    // execution(* PACKAGE.*.*(..))
    @Before("execution(* com.mahmood.spring_Aop.business.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint){

        logger.info("Method is called - {}", joinPoint);

    }
}
