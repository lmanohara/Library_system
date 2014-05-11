package com.spring.librarysystem.service;

import com.spring.librarysystem.dao.MaterialDAO;
import com.spring.librarysystem.dto.Book;
import com.spring.librarysystem.dto.Magazine;
import com.spring.librarysystem.dto.Material;
import com.spring.librarysystem.dto.Newspaper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lahiru on 5/4/2014.
 */
public class MaterialServiceImpl implements MaterialService {

    private MaterialDAO materialDAO;



    @Override
    public void insertMagazine(Magazine magazine) throws SQLException{
            materialDAO.insertMagazine(magazine);
    }

    public MaterialDAO getMaterialDAO() {
        return materialDAO;
    }

    public void setMaterialDAO(MaterialDAO materialDAO) {
        this.materialDAO = materialDAO;
    }

    @Override
    public void insertNewspaper(Newspaper newspaper) throws SQLException{
            materialDAO.insertNewspaper(newspaper);
    }

    @Override
    public void insertBook(Book book) throws SQLException{
            materialDAO.insertBook(book);
    }

    @Override
    public void deleteMagazine(Magazine magazine) throws  SQLException{
        materialDAO.deleteMagazine(magazine);
    }
    @Override
    public void deleteNewspaper(Newspaper newspaper) throws  SQLException{
        materialDAO.deleteNewspaper(newspaper);
    }
    @Override
    public void deleteBook(Book book) throws  SQLException{
        materialDAO.deleteBook(book);
    }

    @Override
    public void updateMagazine(Magazine magazine) throws SQLException{
        materialDAO.updateMagazine(magazine);
    }
    @Override
    public void updateNewspaper(Newspaper newspaper) throws SQLException{
        materialDAO.updateNewspaper(newspaper);
    }
    @Override
    public void updateBook(Book book) throws SQLException{
        materialDAO.updateBook(book);
    }

    @Override
    public List<Magazine> viewAllMagazine() throws  SQLException{
        return materialDAO.viewAllMagazine();
    }
    @Override
    public List<Newspaper> viewAllNewspaper() throws  SQLException{
        return materialDAO.viewAllNewspaper();
    }
    @Override
    public List<Book> viewAllBook() throws  SQLException{
        return materialDAO.viewAllBook();
    }

}
