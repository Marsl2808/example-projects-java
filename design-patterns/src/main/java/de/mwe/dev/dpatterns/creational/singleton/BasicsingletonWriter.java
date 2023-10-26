package de.mwe.dev.dpatterns.creational.singleton;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class BasicsingletonWriter {

  static void saveToFile(BasicSingleton singleton, String filename) throws Exception {
    try (FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
      out.writeObject(singleton);
    }
  }
}
