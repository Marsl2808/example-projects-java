package de.mwe.dev.dpatterns.creational.factory.abstractf;

public class CoffeeFactory implements HotDrinkFactory{

  @Override
  public HotDrink prepare(int amount) {
    System.out.println("making " + amount + " coffees.... enjoy");
    return new Coffee();
  }
  
}
