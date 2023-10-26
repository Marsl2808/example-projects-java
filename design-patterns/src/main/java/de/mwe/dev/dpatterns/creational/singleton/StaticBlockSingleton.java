package de.mwe.dev.dpatterns.creational.singleton;

import java.io.File;
import java.io.IOException;

/**
 * In case of Exceptions during ctor call
 */
public class StaticBlockSingleton {
 
  private StaticBlockSingleton() throws IOException{
    System.out.println("Init static Block Singleton");
    File.createTempFile(".", ".");
  }

  private static StaticBlockSingleton instance;

  static{
    try{
      instance = new StaticBlockSingleton();
    }catch(Exception e){
      System.out.println("Failed to create Singleton");
    }
  }

  public static StaticBlockSingleton getInstance(){
    return instance;
  }
}
