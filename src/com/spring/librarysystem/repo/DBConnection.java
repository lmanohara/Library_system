package com.spring.librarysystem.repo;

import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by Lahiru on 5/4/2014.
 */
public interface DBConnection {
    public Connection getConnection() throws SQLException;
}
