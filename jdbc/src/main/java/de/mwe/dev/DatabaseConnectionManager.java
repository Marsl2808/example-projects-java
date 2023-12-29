package de.mwe.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {

  private final String URL;
  private final Properties properties;

  public DatabaseConnectionManager(String host, String dbName, String userName, String password) {
    this.URL = "jdbc:postgresql://" + host + "/" +dbName;
    this.properties = new Properties();
    this.properties.setProperty("password", password);
    this.properties.setProperty("user", userName);
  }

  public Connection getConnection() throws SQLException{
    return DriverManager.getConnection(URL, this.properties);
  }
}
