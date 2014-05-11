package com.spring.librarysystem.validation;


import com.spring.librarysystem.dto.*;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import javax.xml.validation.Validator;
import java.util.Scanner;
import java.util.*;

/**
 * Created by LahiruI on 5/7/2014.
 */
public class Validation {

//    public boolean isNotNull(String value){
//        if(value.isEmpty()){
//            return false;
//        }
//        return true;
//    }
//
//    public void materialValidation(Material material) {
//
//        Set<ConstraintViolation<Material>> constraintViolationSet = validator.validate(material);
//        System.out.println(material.getName());
//        System.out.println(constraintViolationSet.size());
//
//    }

    ValidatorFactory factory = javax.validation.Validation.buildDefaultValidatorFactory();
    javax.validation.Validator validator = factory.getValidator();



    public void isValidMagazine(Material magazine){
        Set<ConstraintViolation<Material>> constraintViolationSet = validator.validate(magazine);
        System.out.println(constraintViolationSet.iterator().next().getMessage());
        System.out.println(constraintViolationSet.size());

    }
//
//    public boolean isValidNewspaper(Newspaper newspaper){
//        Set<ConstraintViolation<Newspaper>> constraintViolationSet = validator.validate(newspaper);
//        if(constraintViolationSet.size() == 0){
//            return  true;
//        }
//        System.out.println(constraintViolationSet.iterator().next().getMessage());
//        return false;
//    }
//
//    public boolean isValidBook(Book book){
//        Set<ConstraintViolation<Book>> constraintViolationSet = validator.validate(book);
//        if(constraintViolationSet.size() == 0){
//            return  true;
//        }
//        System.out.println(constraintViolationSet.iterator().next().getMessage());
//        return false;
//    }
//
//    public boolean isValidSilverMember(SilverMember silverMember){
//        Set<ConstraintViolation<SilverMember>> constraintViolationSet = validator.validate(silverMember);
//        if(constraintViolationSet.size() == 0){
//            return  true;
//        }
//        System.out.println(constraintViolationSet.iterator().next().getMessage());
//        return false;
//
//    }
//
//    public boolean isValidGoldMember(GoldMember goldMember){
//        Set<ConstraintViolation<GoldMember>> constraintViolationSet = validator.validate(goldMember);
//        if(constraintViolationSet.size() == 0){
//            return  true;
//        }
//        System.out.println(constraintViolationSet.iterator().next().getMessage());
//        return false;
//    }
//
//    public boolean isValidMemebr(Member member){
//        Set<ConstraintViolation<Member>> constraintViolationSet = validator.validate(member);
//        if(constraintViolationSet.size() == 0){
//            return  true;
//        }
//        System.out.println(constraintViolationSet.iterator().next().getMessage());
//        return false;
//    }



}
