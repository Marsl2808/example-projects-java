package de.mwe.dev.dpatterns.creational.builder.person;

public class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

  public EmployeeBuilder position(String position){
    p.position = position;
    return self();
  }

  @Override
  public EmployeeBuilder self() {
    return this;
  }
}
