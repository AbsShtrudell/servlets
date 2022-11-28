package com.shtrudell.util;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.*;

class ConnectorDBTest {

    @Test
    @DisplayName("Should connect to DB")
    void testClass() {
        try {
            var connection = ConnectorDB.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to connect. SQLException.");
        }
    }
}
