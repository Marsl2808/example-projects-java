package de.mwe.dev.dpatterns.creational.builder.person;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class EmployeeBuilderTest {
  @Test
  void testPosition() {
    Person p = new EmployeeBuilder()
        .name("harri")
        .position("cto")
        .build();

    assertNotNull(p);
    System.out.println(p);
  }
}
