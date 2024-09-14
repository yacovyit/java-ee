package org.example;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        // connect to db
        String password = "example";
        String userName = "postgres";
        String url = "jdbc:postgresql://localhost/postgres";
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Connected!!!");

            PersonRepository personRepository = new PersonRepository(connection);

            personRepository.addPerson("Harry", "Potter", "london", "+1232-222");
            personRepository.printAllPersons();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}