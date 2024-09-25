package com.mahmood.spring_Aop.aopAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

        logger.info("Method is called - {} - with arguments: {}", joinPoint, joinPoint.getArgs());

    }

    // Before: before calling
    // After: after calling even when there is an exception
    // AfterThrowing: after the method throws an exception
        // can take 3 arguments (pointcut, throwing(the exception),
    // AfterReturning: after the method returns without exception

    @AfterThrowing(
            pointcut = "execution(* com.mahmood.spring_Aop.business.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCall(JoinPoint joinPoint, Exception exception){

        logger.info("Method is called - {} has thrown exception - {}",
                joinPoint, exception.getMessage());

    }

    @AfterReturning(
            pointcut = "execution(* com.mahmood.spring_Aop.business.*.*(..))",
            returning = "value"
    )
    public void logMethodCall(JoinPoint joinPoint, Object value){

        logger.info("Method is called - {} has returned - {}",
                joinPoint, value);

    }
}
