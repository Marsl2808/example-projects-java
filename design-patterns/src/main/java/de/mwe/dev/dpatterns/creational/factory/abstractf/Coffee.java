package de.mwe.dev.dpatterns.creational.factory.abstractf;

public class Coffee implements HotDrink {

  @Override
  public void consume() {
    System.out.println("drinking coffee");
  }
}
