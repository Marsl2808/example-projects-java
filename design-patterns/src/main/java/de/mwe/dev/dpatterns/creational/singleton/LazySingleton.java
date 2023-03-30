package de.mwe.dev.dpatterns.creational.singleton;

public class LazySingleton {
  
  private static LazySingleton instance;

  private LazySingleton(){
    System.out.println("Init Lazy Sinleton!");
  }

  // need to be thread safe!
  public static synchronized LazySingleton getInstance(){
    if(instance == null){
      instance = new LazySingleton();
    }
    return instance;
  }
}
