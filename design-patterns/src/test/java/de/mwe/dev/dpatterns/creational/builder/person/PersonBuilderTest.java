package de.mwe.dev.dpatterns.creational.builder.person;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class PersonBuilderTest {
  @Test
  void testName() {
    Person p = new PersonBuilder<>()
        .name("jonny")
        .build();

    assertNotNull(p);
    System.out.println(p);
  }
}
