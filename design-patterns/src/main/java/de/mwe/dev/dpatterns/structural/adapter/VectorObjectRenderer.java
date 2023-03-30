package de.mwe.dev.dpatterns.structural.adapter;

import java.util.List;

public class VectorObjectRenderer {

  public static void draw(List<VectorObject> vectorObjects) {
    for (VectorObject vo : vectorObjects) {
      for (Line line : vo) {
        LineToPointAdapter adapter = new LineToPointAdapter(line);
        adapter.forEach(PointRenderer::drawPoint);
      }
    }
  }
}
