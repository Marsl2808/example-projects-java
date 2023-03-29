package de.mwe.dev.dpatterns.creational.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BasicSingletonTest {
  @Test
  void testSerialization() throws Exception {
    BasicSingleton singleton = BasicSingleton.getInstance();
    singleton.setValue(111);

    String filename = "singleton.bin";
    BasicsingletonWriter.saveToFile(singleton, filename);

    singleton.setValue(222);

    BasicSingleton singleton2 = BasicSingletonReader.readFromFile(filename);
    System.out.println(singleton == singleton2);
    assertTrue(singleton == singleton2);
    assertEquals(singleton.getValue(), singleton2.getValue());
  }
}
