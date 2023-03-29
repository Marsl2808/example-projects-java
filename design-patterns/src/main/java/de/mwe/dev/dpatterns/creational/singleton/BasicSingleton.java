package de.mwe.dev.dpatterns.creational.singleton;

import java.io.Serializable;

class BasicSingleton implements Serializable
{
  // cannot new this class, however
  // * instance can be created deliberately (reflection)
  // * instance can be created accidentally (serialization) -> readresolve impl
  private BasicSingleton() {
    System.out.println("Singleton is initializing");
  }

  private static final BasicSingleton INSTANCE = new BasicSingleton();

  private int value = 0;

  public int getValue(){
    return value;
  }
  public void setValue(int value){
    this.value = value;
  }

  // required for correct serialization
  // readResolve is used for _replacing_ the object read from the stream
  protected Object readResolve(){
    return INSTANCE;
  }

  public static BasicSingleton getInstance(){
    return INSTANCE;
  }
}






