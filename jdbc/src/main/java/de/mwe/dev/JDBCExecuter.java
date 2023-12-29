package de.mwe.dev;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCExecuter {

  public static void main(String[] args) {
    DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager("localhost", "hplussport",
        "postgres", "pw");

    try (Connection connection = databaseConnectionManager.getConnection();
        Statement statement = connection.createStatement();) {
      ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
      while (resultSet.next()) {
        System.out.println(resultSet.getInt(1));
      }
    } catch (SQLException e) {
      System.out.println("SQL-Exception occured");
    }
  }
}
