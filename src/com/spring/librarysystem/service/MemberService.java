package com.spring.librarysystem.service;

import com.spring.librarysystem.dto.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lahiru on 5/4/2014.
 */
public interface MemberService {
    void insertSilverMember(SilverMember silverMember) throws SQLException;

    void insertGoldMember(GoldMember goldMember) throws SQLException;

    void deleteSilverMember(SilverMember silverMember) throws SQLException;

    void deleteGoldMember(GoldMember goldMember) throws SQLException;

    void updateSilverMember(SilverMember silverMember) throws SQLException;

    void updateGoldMember(GoldMember goldMember) throws SQLException;

    List<SilverMember> viewAllSilverMember() throws  SQLException;

    List<Book> selectBrrowedBook(Member member) throws  SQLException;

    void insertBorrowBook(Member member) throws SQLException;

    List<GoldMember> viewGoldMember() throws SQLException;
}
