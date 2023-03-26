package de.mwe.dev.dpatterns.creational.factory.abstractf;

public class HotChocolateFactory implements HotDrinkFactory{

  @Override
  public HotDrink prepare(int amount) {
    System.out.println("Preparing " + amount + " hot choclates.... enjoy!");
    return new HotChocolate();
  }
  
}
