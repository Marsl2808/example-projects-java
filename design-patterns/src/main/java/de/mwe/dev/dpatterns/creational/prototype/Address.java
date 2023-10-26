package de.mwe.dev.dpatterns.creational.prototype;

public class Address {
  
  public String streetName;
  public int houseNumber;

  public Address(String streetName, int houseNumber) {
    this.streetName = streetName;
    this.houseNumber = houseNumber;
  }

  // copy ctor, alternative approach over serialization/deserialization
  public Address(Address other){
    this(other.streetName, other.houseNumber);
  }

  @Override
  public String toString() {
    return "Address [streetName=" + streetName + ", houseNumber=" + houseNumber + "]";
  }
}
