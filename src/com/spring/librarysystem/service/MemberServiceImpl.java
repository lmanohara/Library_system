package com.spring.librarysystem.service;

import com.spring.librarysystem.dao.MemberDAO;
import com.spring.librarysystem.dto.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lahiru on 5/4/2014.
 */
public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO;



    @Override
    public void insertSilverMember(SilverMember silverMember) throws SQLException{
        memberDAO.insertSilverMember(silverMember);
    }

    public MemberDAO getMemberDAO() {
        return memberDAO;
    }

    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public void insertGoldMember(GoldMember goldMember) throws SQLException{
        memberDAO.insertGoldMember(goldMember);
    }

    @Override
    public void deleteSilverMember(SilverMember silverMember) throws SQLException{
        memberDAO.deleteSilverMember(silverMember);
    }

    @Override
    public void deleteGoldMember(GoldMember goldMember) throws SQLException{
        memberDAO.deleteGoldMember(goldMember);
    }

    @Override
    public void updateSilverMember(SilverMember silverMember) throws SQLException{
        memberDAO.updateSilverMember(silverMember);
    }

    @Override
    public void updateGoldMember(GoldMember goldMember) throws SQLException{
        memberDAO.updateGoldMember(goldMember);
    }

    @Override
    public List<SilverMember> viewAllSilverMember() throws  SQLException{
        return memberDAO.viewAllSilverMember();
    }

    @Override
    public List<Book> selectBrrowedBook(Member member) throws  SQLException{
        return memberDAO.selectBorrwedBookTO(member);
    }

    @Override
    public void insertBorrowBook(Member member) throws SQLException{
        memberDAO.insertBorrowdBook(member);
    }

    @Override
    public List<GoldMember> viewGoldMember() throws SQLException{
        return memberDAO.viewGoldMemeber();
    }
}
