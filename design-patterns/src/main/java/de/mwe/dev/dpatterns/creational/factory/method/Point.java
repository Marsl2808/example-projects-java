package de.mwe.dev.dpatterns.creational.factory.method;

public class Point {

  private double x, y;

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  private Point(double a, double b) {
    this.x = a;
    this.y = b;
  }

  public static class Factory {
    public static Point newCartesianPoint(double x, double y) {
      return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
      return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
    }
  }
}
