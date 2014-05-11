package com.spring.librarysystem.service;

import com.spring.librarysystem.dto.Book;
import com.spring.librarysystem.dto.Magazine;
import com.spring.librarysystem.dto.Material;
import com.spring.librarysystem.dto.Newspaper;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Lahiru on 5/4/2014.
 */
public interface MaterialService {
    void insertMagazine(Magazine magazine) throws SQLException;

    void insertNewspaper(Newspaper newspaper) throws SQLException;

    void insertBook(Book book) throws SQLException;

    void deleteMagazine(Magazine magazine) throws  SQLException;

    void deleteNewspaper(Newspaper newspaper) throws  SQLException;

    void deleteBook(Book book) throws  SQLException;

    void updateMagazine(Magazine magazine) throws SQLException;

    void updateNewspaper(Newspaper newspaper) throws SQLException;

    void updateBook(Book book) throws SQLException;

    List<Magazine> viewAllMagazine() throws  SQLException;

    List<Newspaper> viewAllNewspaper() throws  SQLException;

    List<Book> viewAllBook() throws  SQLException;
}
