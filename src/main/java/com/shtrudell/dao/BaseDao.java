package com.shtrudell.dao;

import com.shtrudell.util.ConnectorDB;
import java.sql.*;

public class BaseDao implements AutoCloseable {

    protected Connection connection;

    public BaseDao() {
        try {
            connection = ConnectorDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}