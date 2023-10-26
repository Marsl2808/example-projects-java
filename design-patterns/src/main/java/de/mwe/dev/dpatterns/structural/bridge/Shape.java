package de.mwe.dev.dpatterns.structural.bridge;

/**
 * Shape defines the interface of the abstraction & holds a reference to the
 * implementation.
 * Abstraction (Shape) is decoupled from the concrete implementation of
 * renderer.
 */
public abstract class Shape {

  protected Renderer renderer;

  public Shape(Renderer renderer) {
    this.renderer = renderer;
  }

  public abstract void draw();

  public abstract void resize(float factor);
}
