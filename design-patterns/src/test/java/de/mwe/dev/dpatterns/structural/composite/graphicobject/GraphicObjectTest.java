package de.mwe.dev.dpatterns.structural.composite.graphicobject;

import org.junit.jupiter.api.Test;

public class GraphicObjectTest {
  @Test
  void testObjectHandling() {
    GraphicObject drawing = new GraphicObject();
    drawing.setName("MyDrawing");
    drawing.children.add(new Square("Red"));
    drawing.children.add(new Circle("Yellow"));

    GraphicObject group = new GraphicObject();
    group.children.add(new Circle("Blue"));
    group.children.add(new Square("Blue"));
    drawing.children.add(group);

    // group of objects behave like single object
    System.out.println(drawing);
  }
}
