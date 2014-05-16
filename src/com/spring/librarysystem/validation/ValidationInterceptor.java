package com.spring.librarysystem.validation;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by LahiruI on 5/9/2014.
 */
public class ValidationInterceptor implements AfterReturningAdvice {


    /**
     *method execute before return the value from a method
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o2) throws Throwable {
        if(objects.length != 0) {
            isNull(objects[0]);
        }else if(method.getReturnType().toString().equals("int")){
            isNotValidInt(o);
        }

    }

    //for set boolean value
    private static boolean isValid;


    /**
     *check weather object is null
     */
    public void isNull(Object object){
        if(object.toString().equals("")){
            this.isValid = true;
        }else{

            this.isValid = false;
        }

    }

    /**
     *return the value is valid
     */
    public static boolean isValid(){
        return isValid;
    }

    /**
     *check weather integer is valid
     */
    public void isNotValidInt(Object object){
        int value = (Integer) object;
        if(value <= 0){
            this.isValid = true;
        }else {
            this.isValid = false;
        }

    }

}
