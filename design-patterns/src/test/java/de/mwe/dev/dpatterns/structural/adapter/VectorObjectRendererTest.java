package de.mwe.dev.dpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class VectorObjectRendererTest {
  @Test
  void testDraw() {
    final List<VectorObject> vectorObjects 
    = new ArrayList<>(Arrays.asList(
      new VectorRectangle(1,1,10,10),
      new VectorRectangle(3,3,6,6)
      ));

      VectorObjectRenderer.draw(vectorObjects);
      // Objects should not be generated again (because of caching)
      VectorObjectRenderer.draw(vectorObjects);
  }
}
