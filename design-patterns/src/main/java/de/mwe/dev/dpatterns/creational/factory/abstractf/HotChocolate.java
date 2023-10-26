package de.mwe.dev.dpatterns.creational.factory.abstractf;

public class HotChocolate implements HotDrink {

  @Override
  public void consume() {
    System.out.println("mmhhh drinking hot chocolate");
  }
}
