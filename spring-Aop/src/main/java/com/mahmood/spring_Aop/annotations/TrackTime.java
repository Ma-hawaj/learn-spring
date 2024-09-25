package com.mahmood.spring_Aop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// set the target to methods only
@Target(ElementType.METHOD)
//
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
}
