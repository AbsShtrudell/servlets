package com.shtrudell.util;

import java.sql.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectorDB {

    private static final Logger logger = LogManager.getLogger(ConnectorDB.class);
    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        ResourceBundle resource = ResourceBundle.getBundle("db", Locale.getDefault());
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");

        logger.info("connection establish");
        return DriverManager.getConnection(url, user, pass);
    }
}
