package org.example;

import java.sql.*;

public class PersonRepository {
    private final Connection connection;

    public PersonRepository(Connection connection) {
        this.connection = connection;
    }

    public void printAllPersons() {
        try (Statement statement = this.connection.createStatement()) {
            String query = "select * from person";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String city = resultSet.getString("city");
                String phoneNumber = resultSet.getString("phone_number");

                System.out.println("---------------");
                System.out.println("Person details");
                System.out.println("---------------");
                System.out.println("firstName = " + firstName);
                System.out.println("lastName = " + lastName);
                System.out.println("city = " + city);
                System.out.println("phone_number = " + phoneNumber);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int addPerson(String firstName, String lastName, String city, String phoneNumber) {
        String sql = "INSERT INTO person(first_name, last_name, city, phone_number) "
                + "VALUES(?, ?, ?, ?)";
        try {
            CallableStatement callableStatement = connection.prepareCall(sql);
            callableStatement.setString(1, firstName);
            callableStatement.setString(2, lastName);
            callableStatement.setString(3, city);
            callableStatement.setString(4, phoneNumber);

            int insertedRows = callableStatement.executeUpdate();
            return insertedRows;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
