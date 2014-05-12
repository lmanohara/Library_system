package com.spring.librarysystem.validation;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by LahiruI on 5/9/2014.
 */
public class ValidationInterceptor implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o2) throws Throwable {
        if(objects.length != 0) {
            isNull(objects[0]);
        }else if(method.getReturnType().toString().equals("int")){
            isNotValidInt(o);
        }

    }

    private static boolean isValid;

    public void isNull(Object object){
        if(object.toString().equals("")){
            this.isValid = true;
        }else{

            this.isValid = false;
        }

    }

    public static boolean getIsNull(){
        return isValid;
    }

    public void isNotValidInt(Object object){
        int value = (Integer) object;
        if(value <= 0){
            this.isValid = true;
        }else {
            this.isValid = false;
        }

    }

}
