package com.mahmood.spring_Aop.aopAspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

    @Pointcut("execution(* com.mahmood.spring_Aop.business.*.*(..))")
    public void businessPackageConfig(){ }

    // All beans that contain Service in their name
    @Pointcut("bean(*Service*)")
    public void allServiceBeans(){}

}
