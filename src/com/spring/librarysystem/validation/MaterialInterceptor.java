package com.spring.librarysystem.validation;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by LahiruI on 5/9/2014.
 */
public class MaterialInterceptor implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o2) throws Throwable {
        System.out.println("after returning method....");
        System.out.println(o.toString());
        System.out.println(o2.toString());
        System.out.println(method.toString());
        System.out.println(objects.toString());
    }
}
