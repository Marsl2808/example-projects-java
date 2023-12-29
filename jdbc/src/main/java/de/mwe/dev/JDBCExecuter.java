package de.mwe.dev;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecuter {

  /**
   * psql -h localhost -U postgres -d hplussport
   */
  public static void main(String[] args) {
    DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager("localhost", "hplussport",
        "postgres", "pw");

    try {
      Connection connection = databaseConnectionManager.getConnection();
      CustomerDAO customerDAO = new CustomerDAO(connection);
      // C
      Customer customerCreate = createCustomer(customerDAO);
      System.out.println(customerCreate);
      // R
      Customer customerRead = customerDAO.findById(customerCreate.getId());
      System.out.println(customerRead);
      // U
      customerRead.setFirstName("Hansi");
      customerRead.setLastName("Hinterseher");
      Customer customerUpdate = customerDAO.update(customerRead);
      System.out.println(customerUpdate);
      // D
      customerDAO.delete(customerUpdate.getId());
    } catch (SQLException e) {
      System.out.println("SQL-Exception occured");
    }
  }

  private static Customer createCustomer(CustomerDAO customerDAO) {
    Customer customer = new Customer();
    customer.setFirstName("George");
    customer.setLastName("Washington");
    customer.setEmail("george.washington@wh.gov");
    customer.setPhone("(555) 555-6543");
    customer.setAddress("1234 Main Street");
    customer.setCity("Mount Vernon");
    customer.setState("VA");
    customer.setZipCode("22121");

    return customerDAO.create(customer);
  }
}
