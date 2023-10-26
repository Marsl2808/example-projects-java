package de.mwe.dev.dpatterns.structural.adapter.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SquareToRectangleAdapterTest {
  @Test
  void testMain() {
    Square sq = new Square(11);
    SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(sq);
    assertEquals(121, adapter.getArea());
  }
}
