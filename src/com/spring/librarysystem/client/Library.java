package com.spring.librarysystem.client;

import com.spring.librarysystem.dto.*;
import com.spring.librarysystem.service.MaterialService;
import com.spring.librarysystem.service.MemberService;
import com.spring.librarysystem.validation.Validation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by LahiruI on 5/5/2014.
 */
public class Library {


    int userInput;
    int materialId;
    String materialTitle;
    String materialName;
    int materialType;
    String ISBN;
    int noOfPages;

    int memberId;
    String memberName;
    String memberAddress;
    String creditCardNo;
    String vehicleNo;

    Scanner scanner = new Scanner(System.in);

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    Magazine magazine = applicationContext.getBean("magazine", Magazine.class);
    Newspaper newspaper = applicationContext.getBean("newspaper", Newspaper.class);
    Book book = applicationContext.getBean("book", Book.class);

    SilverMember silverMember = applicationContext.getBean("silverMember", SilverMember.class);
    GoldMember goldMember = applicationContext.getBean("goldMember", GoldMember.class);
    Member member = applicationContext.getBean("member", Member.class);

    MaterialService materialService = applicationContext.getBean("materialService", MaterialService.class);
    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    //Validation validation = applicationContext.getBean("validation", Validation.class);

    public void run(){
        System.out.println("Welcome to the library system..");
        System.out.println("Please select following option to login to the system");
        System.out.println("1.Admin");
        System.out.println("2.Library Member");
        userInput = scanner.nextInt();
        switch (userInput){
            case 1:
                adminMenu();
               break;
            case 2:
                libraryMemberMenu();
                break;
        }

    }

    public void adminMenu(){

            while (userInput != 0) {
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("1.Add Material");
            System.out.println("2.Delete Material");
            System.out.println("3.Update Material");
            System.out.println("4.Add user");
            System.out.println("5.Delete user");
            System.out.println("6.Update user");
            System.out.println("0.exit");
            System.out.println("---------------------------");
            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    addMaterial();
                    break;
                case 2:
                    deleteMaterial();
                    break;
                case 3:
                    updateMaterial();
                    break;
                case 4:
                    addUser();
                    break;
                case 5:
                    deleteUser();
                    break;
                case 6:
                    updateUser();
                    break;

            }
        }
    }

    public void addMaterial(){

        try {
            System.out.println("1.Add magazine");
            System.out.println("2.Add newspaper");
            System.out.println("3.Add book");

            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    magazineDetails();
                    materialService.insertMagazine(magazine);
                    break;
                case 2:
                    newspaperDetails();
                    materialService.insertNewspaper(newspaper);
                    break;
                case 3:
                    bookDetails();
                    materialService.insertBook(book);
                    break;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void magazineDetails(){

            scanner.nextLine();
            System.out.println("Enter magazine title");
            materialTitle = scanner.nextLine();
            magazine.setTitle(materialTitle);
            System.out.println("Enter magazine name");
            materialName = scanner.nextLine();
            magazine.setName(materialName);
            System.out.println("Enter magazine type");
            materialType = scanner.nextInt();
            magazine.setMagazineType(materialType);

            //validation.isValidMaterial(magazine);

    }

    public void newspaperDetails(){

        scanner.nextLine();
        System.out.println("Enter newspaper title");
        materialTitle = scanner.nextLine();
        newspaper.setTitle(materialTitle);
        System.out.println("Enter newspaper name");
        materialName = scanner.nextLine();
        newspaper.setName(materialName);
        Material material = newspaper;
        //validation.isValidMaterial(material);
    }

    public void bookDetails(){
        scanner.nextLine();
        System.out.println("Enter book title");
        materialTitle = scanner.nextLine();
        book.setTitle(materialTitle);
        System.out.println("Enter book name");
        materialName = scanner.nextLine();
        book.setName(materialName);
        System.out.println("Enter book ISBN");
        ISBN = scanner.nextLine();
        book.setISBN(ISBN);
        System.out.println("Enter no of pages");
        noOfPages = scanner.nextInt();
        book.setNoOfPages(noOfPages);
    }

    public void viewAllMagazine(){
        try {

            for(Magazine magazine : materialService.viewAllMagazine()){
                String displayMaterial = magazine.getMeterialId() + " " + magazine.getTitle() + " " + magazine.getName();
                System.out.println(displayMaterial);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void viewAllNewspaper(){
        try {

            for(Material material : materialService.viewAllNewspaper()){
                String displayMaterial = material.getMeterialId() + " " + material.getTitle() + " " + material.getName();
                System.out.println(displayMaterial);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void viewAllBook(){
        try {

            for(Book book : materialService.viewAllBook()){
                String displayMaterial = book.getMeterialId() + " " + book.getTitle() + " " + book.getName()+ " " + book.getISBN() + " " + book.getNoOfPages();
                System.out.println(displayMaterial);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void deleteMaterial(){

       try {
           System.out.println("1.Delete magazine");
           System.out.println("2.Delete newspaper");
           System.out.println("3.Delete book");
           userInput = scanner.nextInt();

           switch (userInput) {
               case 1:
                   viewAllMagazine();
                   materialId = scanner.nextInt();
                   magazine.setMeterialId(materialId);
                   materialService.deleteMagazine(magazine);
                   break;
               case 2:
                   viewAllNewspaper();
                   materialId = scanner.nextInt();
                   newspaper.setMeterialId(materialId);
                   materialService.deleteNewspaper(newspaper);
                   break;
               case 3:
                   viewAllBook();
                   materialId = scanner.nextInt();
                   book.setMeterialId(materialId);
                   materialService.deleteBook(book);
                   break;
           }
       }catch (SQLException ex){

           ex.printStackTrace();
       }
    }

    public void updateMaterial(){

        try {
            System.out.println("1.Update magazine");
            System.out.println("2.Update newspaper");
            System.out.println("3.Update book");

            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    viewAllMagazine();
                    System.out.println("Enter material id");
                    materialId = scanner.nextInt();
                    magazine.setMeterialId(materialId);
                    magazineDetails();
                    materialService.updateMagazine(magazine);
                    break;
                case 2:
                    viewAllNewspaper();
                    System.out.println("Enter material id");
                    materialId = scanner.nextInt();
                    newspaper.setMeterialId(materialId);
                    newspaperDetails();
                    materialService.updateNewspaper(newspaper);
                    break;
                case 3:
                    viewAllBook();
                    System.out.println("Enter material id");
                    materialId = scanner.nextInt();
                    book.setMeterialId(materialId);
                    bookDetails();
                    materialService.updateBook(book);
                    break;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void addUser(){

        try {
            System.out.println("1.Add Silver Member");
            System.out.println("2.Add Gold Member");

            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    silverMemberDetails();
                    memberService.insertSilverMember(silverMember);
                    break;
                case 2:
                    setGoldMemberDetails();
                    memberService.insertGoldMember(goldMember);
                    break;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void silverMemberDetails(){
        scanner.nextLine();
        System.out.println("Enter member name");
        memberName = scanner.nextLine();
        silverMember.setName(memberName);
        System.out.println("Enter member address");
        memberAddress = scanner.nextLine();
        silverMember.setAddress(memberAddress);
    }

    public void setGoldMemberDetails(){
            scanner.nextLine();
            System.out.println("Enter member name");
            memberName = scanner.nextLine();
            goldMember.setName(memberName);
            System.out.println("Enter member address");
            memberAddress = scanner.nextLine();
            goldMember.setAddress(memberAddress);
            System.out.println("Enter member credit card no");
            creditCardNo = scanner.nextLine();
            goldMember.setCreditCardNo(creditCardNo);
            System.out.println("Enter member vehicle no");
            vehicleNo = scanner.nextLine();
            goldMember.setVehicleNo(vehicleNo);

    }

    public void deleteUser(){
        try {
            System.out.println("1.Delete Silver Member");
            System.out.println("2.Delete Gold Member");
            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    viewAllSilverMember();
                    System.out.println("Enter silver member id");
                    memberId = scanner.nextInt();
                    silverMember.setMemberId(memberId);
                    memberService.deleteSilverMember(silverMember);
                    break;
                case 2:
                    viewAllGoldMember();
                    System.out.println("Enter gold member id");
                    memberId = scanner.nextInt();
                    goldMember.setMemberId(memberId);
                    memberService.deleteGoldMember(goldMember);
                    break;
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void updateUser(){
        try {
            System.out.println("1.Update Silver Member");
            System.out.println("2.Update Gold Member");

            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    viewAllSilverMember();
                    System.out.println("Enter silver member id");
                    memberId = scanner.nextInt();
                    silverMember.setMemberId(memberId);
                    silverMemberDetails();
                    memberService.updateSilverMember(silverMember);
                    break;
                case 2:
                    viewAllGoldMember();
                    System.out.println("Enter gold member id");
                    memberId = scanner.nextInt();
                    goldMember.setMemberId(memberId);
                    setGoldMemberDetails();
                    memberService.updateGoldMember(goldMember);
                    break;

            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void viewAllSilverMember(){
        try {

            for(SilverMember silverMember: memberService.viewAllSilverMember()){
                String displayMember = silverMember.getMemberId() + " " + silverMember.getName() + " " + silverMember.getAddress();
                System.out.println(displayMember);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }


    }

    public void viewAllGoldMember(){
        try{
            for(GoldMember goldMember : memberService.viewGoldMember()){
                String displayMember = goldMember.getMemberId() + " "
                        + goldMember.getName() + " "
                        + goldMember.getAddress() + " "
                        + goldMember.getCreditCardNo() + " "
                        + goldMember.getVehicleNo() + " ";
                System.out.println(displayMember);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void libraryMemberMenu(){

        while (userInput !=0 ) {
            System.out.println();
            System.out.println("---------------------------");
            System.out.println("1.View Material");
            System.out.println("2.Borrow book");
            System.out.println("3.Borrowed books");
            System.out.println("0.Exit");
            System.out.println("---------------------------");
            userInput = scanner.nextInt();

            switch (userInput) {
                case 1:
                    viewMaterial();
                    break;
                case 2:
                    viewAllBook();
                    brrowBook();
                    break;
                case 3:
                    brrowedBook();
                    break;
            }
        }

    }

    public void viewMaterial(){
        System.out.println("1.Magazines");
        System.out.println("2.Newspapers");
        System.out.println("3.Books");

        userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                viewAllMagazine();
                break;
            case 2:
                viewAllNewspaper();
                break;
            case 3:
                viewAllBook();
                break;
        }
    }

    public  void brrowBook(){

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String currentDate = dateFormat.format(date);

            System.out.println("Enter book id");
            materialId = scanner.nextInt();
            book.setMeterialId(materialId);
            member.setMaterial(book);
            System.out.println("Enter member id");
            memberId = scanner.nextInt();
            member.setMemberId(memberId);
            member.setBorrowDate(currentDate);

            memberService.insertBorrowBook(member);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public void brrowedBook(){
        //use inheritance

        try {
            System.out.println("Enter your member id");
            memberId = scanner.nextInt();
            member.setMemberId(memberId);
            //memberService.selectBrrowedBook(silverMember);
            for(Book book : memberService.selectBrrowedBook(member)){
                String displayBook= book.getTitle() + " " + book.getName() + " " + book.getISBN();
                System.out.println(displayBook);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }




}
