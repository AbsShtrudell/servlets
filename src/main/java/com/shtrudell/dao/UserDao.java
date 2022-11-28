package com.shtrudell.dao;

import com.shtrudell.model.User;
import java.sql.SQLException;


public class UserDao extends BaseDao {
    private static final String SQL_GET_USER = "select login,passw from users where login=? and passw=?";
    private static final String SQL_CHECK_LOGIN = "SELECT login FROM users WHERE login = ?";
    private static final String SQL_INSERT_USER = "INSERT INTO users(login ,passw) VALUES (? , ?)";

    public UserDao() {
        super();
    }

    public boolean isValidUser(final String login, final byte[] password) {

        try (var ps = connection.prepareStatement(SQL_GET_USER)) {
            ps.setString(1, login);
            ps.setBytes(2, password);

            var resultSet = ps.executeQuery();

            while (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return false;
    }

    public boolean insertUser(User user) {
        try {
            var preparedStatement = connection.prepareStatement(SQL_CHECK_LOGIN);

            preparedStatement.setString(1, user.getLogin());
            var result = preparedStatement.executeQuery();

            if (result.next()) {
                preparedStatement.close();
                return false;
            }
            else {
                preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setBytes(2, user.getPassw());
                preparedStatement.executeUpdate();
                preparedStatement.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

