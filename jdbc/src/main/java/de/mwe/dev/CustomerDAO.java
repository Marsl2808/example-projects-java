package de.mwe.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import de.mwe.dev.util.DataAccessObject;

public class CustomerDAO extends DataAccessObject<Customer> {

  private static final String INSERT = "INSERT INTO customer (first_name, last_name, email, phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

  public CustomerDAO(Connection connection) {
    super(connection);
  }

  @Override
  public Customer findById(long id) {
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public List<Customer> findAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public Customer update(Customer dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public Customer create(Customer dto) {
    try(PreparedStatement preparedStatement = this.connection.prepareStatement(INSERT)){
      preparedStatement.setString(1, dto.getFirstName());
      preparedStatement.setString(2, dto.getLastName());
      preparedStatement.setString(3, dto.getEmail());
      preparedStatement.setString(4, dto.getPhone());
      preparedStatement.setString(5, dto.getAddress());
      preparedStatement.setString(6, dto.getCity());
      preparedStatement.setString(7, dto.getState());
      preparedStatement.setString(8, dto.getZipCode());
      preparedStatement.execute();
      return null;
    }catch(SQLException e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public void delete(long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

}
