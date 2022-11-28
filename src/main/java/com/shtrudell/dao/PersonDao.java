package com.shtrudell.dao;

import com.shtrudell.model.Person;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;
import java.util.*;

public class PersonDao extends BaseDao {

    private final static String SQL_GET_PERSONS = "SELECT * FROM persons";
    private final static String SQL_INSERT_PERSONS = "INSERT INTO persons(pname, phone, email) VALUES (?,?,?)";
    private static final Logger logger = LogManager.getLogger(PersonDao.class);

    public PersonDao() {
        super();
    }

    public void insertPerson(Person person) {
        try (var preparedStatement = connection.prepareStatement(SQL_INSERT_PERSONS)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPhone());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();

            logger.info("new person: " + person);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Person> getPersons() {
        var persons = new ArrayList<Person>();

        try (
                var statement = connection.createStatement();
                var resultSet = statement.executeQuery(SQL_GET_PERSONS)
        ) {
            while (resultSet.next()) {
                var person = new Person();

                person.setName(resultSet.getString("pname"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));

                persons.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

}