package com.spring.librarysystem.repo;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by Lahiru on 5/4/2014.
 */
public class DBConnectionImpl implements DBConnection {

    private String userName;

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Connection getConnection() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/library", this.userName, this.password);
        return conn;
    }

}
