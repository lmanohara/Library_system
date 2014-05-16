package com.spring.librarysystem.dao;

import com.spring.librarysystem.dto.Book;
import com.spring.librarysystem.dto.Magazine;
import com.spring.librarysystem.dto.Newspaper;
import com.spring.librarysystem.repo.DBConnection;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lahiru on 5/4/2014.
 */
public class MaterialDAOImpl implements MaterialDAO {

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
     *insert a magazine to the db
     */
    @Override
    public void insertMagazine(Magazine magazine) throws SQLException{
        String query = "INSERT INTO magazine (title, name, type_id) VALUES('"
                + magazine.getTitle() + "','"
                + magazine.getName() + "',"
                + magazine.getMagazineType()
                + ")";
        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);

    }

    /**
     *insert a newspaper to the db
     */
    @Override
    public void insertNewspaper(Newspaper newspaper) throws SQLException{
        String query = "INSERT INTO newspaper (title, name) VALUES('"
                + newspaper.getTitle() + "','"
                + newspaper.getName() + "'"
                + ")";
        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);

    }

    /**
     *insert a book to the db
     */
    @Override
    public void insertBook(Book book) throws SQLException{
        String query = "INSERT INTO book (title, name, ISBN, no_of_pages) VALUES('"
                + book.getTitle() + "','"
                + book.getName() + "','"
                + book.getISBN() + "',"
                + book.getNoOfPages()
                + ")";
        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);

    }

    /**
     *delete a magazine from db
     */
    @Override
    public void deleteMagazine(Magazine magazine) throws SQLException{
        String query = "DELETE FROM magazine WHERE mag_id ="
                +magazine.getMeterialId();

        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    /**
     *delete a newspaper from db
     */
    @Override
    public void deleteNewspaper(Newspaper newspaper) throws SQLException{
        String query = "DELETE FROM newspaper WHERE np_id ="
                +newspaper.getMeterialId();

        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    /**
     *delete a book from the db
     */
    @Override
    public void deleteBook(Book book) throws SQLException{
        String query = "DELETE FROM magazine WHERE book_id ="
                +book.getMeterialId();

        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    /**
     *update details of the magazine
     */
    @Override
    public void updateMagazine(Magazine magazine)throws SQLException{
        String query = "UPDATE magazine SET title = '"
                + magazine.getTitle() +"', name = '"
                + magazine.getName() + "', type_id ="
                + magazine.getMagazineType() + " WHERE mag_id= "
                + magazine.getMeterialId();

        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    /**
     *update details of the newspaper
     */
    @Override
    public void updateNewspaper(Newspaper newspaper)throws SQLException{
        String query = "UPDATE magazine SET title = '"
                + newspaper.getTitle() +"', name = '"
                + newspaper.getName() + "' WHERE np_id= "
                + newspaper.getMeterialId();

        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    /**
     *update details of the book
     */
    @Override
    public void updateBook(Book book)throws SQLException{
        String query = "UPDATE newspaper SET title = '"
                + book.getTitle() +"', name = '"
                + book.getName() + "', ISBN = '"
                + book.getISBN() + "', no_of_pages ="
                + book.getNoOfPages() +" WHERE book_id= "
                + book.getMeterialId();

        Connection conn = connection.getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }

    //search method
//    public Material findMaterial(Material material) throws SQLException{
//        Connection conn = connection.getConnection();
//    }

//    public Collections selectReviewerTO(Material material)throws SQLException{
//        Connection conn = connection.getConnection();
//        String query = "SELECT  FROM ";
//
//        Connection conn = connection.getConnection();
//        Statement statement = conn.createStatement();
//        statement.executeUpdate(query);
//    }

//    public Collections selectAuditorTO(Material material) throws SQLException{
//        Connection conn = connection.getConnection();
//    }

    /**
     *return all magazine from the db
     */
    @Override
    public List<Magazine> viewAllMagazine() throws SQLException{
        Connection conn = connection.getConnection();
        String query = "SELECT mag_id, title, name FROM magazine";
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery(query);
        List<Magazine> magazines = new ArrayList<Magazine>();
        while (resultSet.next()){
            Magazine magazine = new Magazine();
            magazine.setMeterialId(resultSet.getInt(1));
            magazine.setTitle(resultSet.getString(2));
            magazine.setName(resultSet.getString(3));

            magazines.add(magazine);
        }

        return  magazines;
    }

    /**
     *return all newspaper from the db
     */
    @Override
    public List<Newspaper> viewAllNewspaper() throws SQLException{
        Connection conn = connection.getConnection();
        String query = "SELECT np_id, title, name FROM newspaper";
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery(query);
        List<Newspaper> newspapers = new ArrayList<Newspaper>();
        while (resultSet.next()){
            Newspaper newspaper = new Newspaper();
            newspaper.setMeterialId(resultSet.getInt(1));
            newspaper.setTitle(resultSet.getString(2));
            newspaper.setName(resultSet.getString(3));

            newspapers.add(newspaper);
        }

        return  newspapers;
    }

    /**
     *return all book from the db
     */
    @Override
    public List<Book> viewAllBook() throws  SQLException{
        Connection conn = connection.getConnection();
        String query = "SELECT book_id, title, name, ISBN, no_of_pages FROM book";
        Statement statement = conn.createStatement();
        ResultSet resultSet =  statement.executeQuery(query);
        List<Book> books = new ArrayList<Book>();
        while (resultSet.next()){
            Book book = new Book();
            book.setMeterialId(resultSet.getInt(1));
            book.setTitle(resultSet.getString(2));
            book.setName(resultSet.getString(3));
            book.setISBN(resultSet.getString(4));
            book.setNoOfPages(resultSet.getInt(5));

            books.add(book);
        }

        return  books;
    }



}
