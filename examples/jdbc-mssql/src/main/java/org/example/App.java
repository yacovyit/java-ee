package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Connection connection = null;

        // connect to db
        String userName = "sa";
        String password = "Password1";

        String url = "jdbc:sqlserver://localhost:1433;databaseName=demo";

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
