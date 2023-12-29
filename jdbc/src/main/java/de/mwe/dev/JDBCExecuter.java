package de.mwe.dev;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCExecuter {

  public static void main(String[] args) {
    DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager("localhost", "hplussport",
        "postgres", "pw");

    try {
      Connection connection = databaseConnectionManager.getConnection();
      CustomerDAO customerDAO = new CustomerDAO(connection);
      Customer customer = new Customer();
      customer.setFirstName("George");
      customer.setLastName("Washington");
      customer.setEmail("george.washington@wh.gov");
      customer.setPhone("(555) 555-6543");
      customer.setAddress("1234 Main Street");
      customer.setCity("Mount Vernon");
      customer.setState("VA");
      customer.setZipCode("22121");

      customerDAO.create(customer);
    } catch (SQLException e) {
      System.out.println("SQL-Exception occured");
    }
  }
}
