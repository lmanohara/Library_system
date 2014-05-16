package com.spring.librarysystem.dao;

import com.spring.librarysystem.dto.*;
import com.spring.librarysystem.repo.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lahiru on 5/4/2014.
 */
public class MemberDAOImpl implements MemberDAO {


    private DBConnection connection;

    /**
     *return mysql connection instance
     */
    @Override
    public DBConnection getConnection() {
        return connection;
    }


    /**
     *set mysql connection instance
     */
    @Override
    public void setConnection(DBConnection connection) {
        this.connection = connection;
    }

    /**
     *insert a silver member to the db
     */
    @Override
    public void insertSilverMember(SilverMember silverMember) throws SQLException{
        String query = "INSERT INTO member (name, address) VALUES('"
                + silverMember.getName() + "','"
                + silverMember.getAddress() + "'"
                + ")";
        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
        conn.close();
    }

    /**
     *insert a gold member to the db
     */
    @Override
    public void insertGoldMember(GoldMember goldMember) throws SQLException{
        Connection conn = connection.getConnection();

        conn.setAutoCommit(false);
        String query = "INSERT INTO member ( name, address) VALUES('"
                + goldMember.getName() + "','"
                + goldMember.getAddress() + "'"
                + ")";
        String queryGoldMember = "INSERT INTO gold_member (credit_card_no, vehicle_no, member_id) SELECT '"
                + goldMember.getCreditCardNo() + "','"
                + goldMember.getVehicleNo() + "', m.member_id FROM member m WHERE m.name = '"
                + goldMember.getName() + "'";


        PreparedStatement statement1 = conn.prepareStatement(query);
        statement1.executeUpdate();
        PreparedStatement statement2 = conn.prepareStatement(queryGoldMember);
        statement2.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     *delete a silver member from db
     */
    @Override
    public void deleteSilverMember(SilverMember silverMember) throws SQLException{
        String query = "DELETE FROM member WHERE member_id ="
                +silverMember.getMemberId();
        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);

    }

    /**
     *delete a gold member from db
     */
    @Override
    public void deleteGoldMember(GoldMember goldMember) throws SQLException{
        Connection conn = connection.getConnection();
        String query = "DELETE FROM member WHERE member_id ="
                +goldMember.getMemberId();

        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
      conn.close();

    }


    /**
     *find a member from db
     */
//    public Member findMember(Member member) throws  SQLException{
//        Connection conn = connection.getConnection();
//    }


    /**
     * Update details of the silver member
     */
    @Override
    public void updateSilverMember(SilverMember silverMember) throws SQLException{
        String query = "UPDATE member SET name = '"
                + silverMember.getName() +"', address = '"
                + silverMember.getAddress() + "' WHERE member_id ="
                + silverMember.getMemberId();

        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
        conn.close();
    }

    /**
     *Update details of the gold member
     */
    @Override
    public void updateGoldMember(GoldMember goldMember) throws SQLException{

        Connection conn = connection.getConnection();
        conn.setAutoCommit(false);

        String query = "UPDATE member SET name = '"
                + goldMember.getName() +"', address = '"
                + goldMember.getAddress() + "' where member_id ="
                + goldMember.getMemberId();

        String queryGoldMember = "UPDATE gold_member SET credit_card_no = '"
                + goldMember.getCreditCardNo() +"', vehicle_no = '"
                + goldMember.getVehicleNo() + "' WHERE member_id ="
                + goldMember.getMemberId();


        PreparedStatement statement1 = conn.prepareStatement(query);
        statement1.executeUpdate();
        PreparedStatement statement2 = conn.prepareStatement(queryGoldMember);
        statement2.executeUpdate();
        conn.commit();
        conn.close();
    }

    /**
     *return all silver member from db
     */
    @Override
    public List<SilverMember> viewAllSilverMember() throws  SQLException{
        Connection conn = connection.getConnection();
        String query = "SELECT m.member_id, m.name, m.address FROM member m LEFT OUTER JOIN gold_member gm ON gm.member_id = m.member_id WHERE gm.member_id IS null; ";
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery(query);
        List<SilverMember> silverMembers = new ArrayList<SilverMember>();
        while (resultSet.next()){
            SilverMember silverMember = new SilverMember();
            silverMember.setMemberId(resultSet.getInt(1));
            silverMember.setName(resultSet.getString(2));
            silverMember.setAddress(resultSet.getString(3));

            silverMembers.add(silverMember);
        }

        return  silverMembers;
    }

    /**
     *return all borrowed books for a member
     */
    @Override
    public List<Book> selectBorrwedBookTO(Member member) throws SQLException{
        Connection conn = connection.getConnection();
        String query = "SELECT b.title, b.name, b.ISBN FROM book b  INNER JOIN borrowed_by bb ON bb.book_id = b.book_id INNER JOIN member m ON m.member_id = bb.member_id WHERE m.member_id = "+member.getMemberId();
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery(query);
        List<Book> brrowedBooks = new ArrayList<Book>();
        while (resultSet.next()){
            Book brrowedBook = new Book();
            brrowedBook.setTitle(resultSet.getString(1));
            brrowedBook.setName(resultSet.getString(2));
            brrowedBook.setISBN(resultSet.getString(3));

            brrowedBooks.add(brrowedBook);
        }

        return  brrowedBooks;
    }

    /**
     *insert a borrow book for a member
     */
    @Override
    public void insertBorrowdBook(Member member) throws SQLException{
        Connection conn = connection.getConnection();
        String query = "INSERT INTO borrowed_by (member_id, book_id, date) VALUES("
                + member.getMemberId() + ", "
                + member.getMaterial().getMeterialId() + ", '"
                + member.getBorrowDate() + "')";
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
        conn.close();
    }

    /**
     * return all gold member from db
     */
    @Override
    public List<GoldMember> viewGoldMemeber() throws SQLException{
        Connection conn = connection.getConnection();
        String query = "SELECT m.member_id, m.name, m.address, gm.credit_card_no, gm.vehicle_no FROM member m INNER JOIN gold_member gm ON gm.member_id = m.member_id";
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery(query);
        List<GoldMember> goldMembers = new ArrayList<GoldMember>();
        while (resultSet.next()){
            GoldMember goldMember = new GoldMember();
            goldMember.setMemberId(resultSet.getInt(1));
            goldMember.setName(resultSet.getString(2));
            goldMember.setAddress(resultSet.getString(3));
            goldMember.setCreditCardNo(resultSet.getString(4));
            goldMember.setVehicleNo(resultSet.getString(5));

            goldMembers.add(goldMember);
        }

        return  goldMembers;
    }

}
