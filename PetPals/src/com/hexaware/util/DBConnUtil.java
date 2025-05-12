package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Utility class to create a database connection using loaded properties.
public class DBConnUtil {

    // Establishes a connection to the database using the provided properties.
    public static Connection getConnection(Properties props) throws SQLException {
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }
}
