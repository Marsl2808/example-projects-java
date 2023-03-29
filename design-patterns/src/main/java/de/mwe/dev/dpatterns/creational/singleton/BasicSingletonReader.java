package de.mwe.dev.dpatterns.creational.singleton;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class BasicSingletonReader {
  static BasicSingleton readFromFile(String filename) throws Exception{
    try (FileInputStream fileIn = new FileInputStream(filename);
         ObjectInputStream in = new ObjectInputStream(fileIn) )
    {
      return (BasicSingleton)in.readObject();
    }
  }
}

