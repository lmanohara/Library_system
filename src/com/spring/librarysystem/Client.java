package com.spring.librarysystem;

import com.spring.librarysystem.client.Library;
import com.spring.librarysystem.dto.Magazine;
import com.spring.librarysystem.dto.Material;
import com.spring.librarysystem.dto.Member;
import com.spring.librarysystem.service.MemberService;
import com.spring.librarysystem.validation.Validation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by Lahiru on 5/4/2014.
 */
public class Client {

    public static void main(String[] args) {

//        Library library = new Library();
//        library.run();

          ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Material magazine = applicationContext.getBean("material", Material.class);
//        magazine.setTitle("NY mag");
//        magazine.setName("New york mag");
//        com.spring.librarysystem.validation.Validation validation = new Validation();
//        validation.isValidMagazine(magazine);

        Magazine magazine = applicationContext.getBean("cachedService", Magazine.class);
        System.out.println(magazine.getName());
    }
}
