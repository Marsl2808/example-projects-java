package de.mwe.dev.dpatterns.structural.composite.graphicobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * class is not abstract, because it will be used for grouping.
 */
public class GraphicObject {

  protected String name = "Group";
  public List<GraphicObject> children = new ArrayList<>();
  public String color;

  public GraphicObject() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private void print(StringBuilder stringBuilder, int depth) {
    stringBuilder.append(String.join("", Collections.nCopies(depth, "*")))
        .append(depth > 0 ? " " : "")
        .append((color == null || color.isEmpty()) ? "" : color + " ")
        .append(getName())
        .append(System.lineSeparator());
    for (GraphicObject child : children)
      child.print(stringBuilder, depth + 1);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    print(sb, 0);
    return sb.toString();
  }
}
