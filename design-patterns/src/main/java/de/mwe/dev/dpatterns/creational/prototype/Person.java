package de.mwe.dev.dpatterns.creational.prototype;

import java.util.Arrays;

public class Person {

  public String[] names;
  public Address address;

  public Person(String[] names, Address address) {
    this.names = names;
    this.address = address;
  }

  // copy ctor, alternative approach over serialization/deserialization
  public Person(Person other){
    names = other.names.clone();
    address = new Address(other.address);
  }

  @Override
  public String toString() {
    return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
  }
}
