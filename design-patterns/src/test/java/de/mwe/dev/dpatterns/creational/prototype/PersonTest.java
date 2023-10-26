package de.mwe.dev.dpatterns.creational.prototype;

import org.junit.jupiter.api.Test;

public class PersonTest {
  @Test
  void testCopy() {
    Person john = new Person(new String[] { "John", "Smith" }, new Address("London Road", 123));
    Person jane = new Person(john);

    jane.names[0] = "Jane";
    jane.address.houseNumber = 444;

    System.out.println(jane);
    System.out.println(john);
  }
}
