package com.spring.librarysystem.dao;

import com.spring.librarysystem.dto.*;
import com.spring.librarysystem.repo.DBConnection;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lahiru on 5/4/2014.
 */
public interface MemberDAO {
    DBConnection getConnection();

    void setConnection(DBConnection connection);

    void insertSilverMember(SilverMember silverMember) throws SQLException;

    void insertGoldMember(GoldMember goldMember) throws SQLException;

    void deleteSilverMember(SilverMember silverMember) throws SQLException;

    void deleteGoldMember(GoldMember goldMember) throws SQLException;

    void updateSilverMember(SilverMember silverMember) throws SQLException;

    void updateGoldMember(GoldMember goldMember) throws SQLException;

    List<SilverMember> viewAllSilverMember() throws  SQLException;

    List<Book> selectBorrwedBookTO(Member member) throws SQLException;

    void insertBorrowdBook(Member member) throws  SQLException;

     List<GoldMember> viewGoldMemeber() throws SQLException;
}
