package de.mwe.dev.dpatterns.creational.factory.method;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PointTest {

  static final double RHO = .5;
  static final double THETA = Math.PI / 4;
  static final double X = 30.5;
  static final double Y = 27.867; 

  @Test
  void pointFactoryTest() {
    
    Point myCartesianPoint = Point.Factory.newCartesianPoint(X, Y);
    Point myPolarPoint = Point.Factory.newPolarPoint(.5f, Math.PI / 4);

    System.out.println("Polarpoint: x = "+ myPolarPoint.getX() + " / y = " + myPolarPoint.getY());
    System.out.println("Cartesianpoint: x = " + myCartesianPoint.getX() + " / y = " + myCartesianPoint.getY());
    assertEquals( myPolarPoint.getX(), RHO * Math.cos(THETA));
    assertEquals(myPolarPoint.getY(), RHO * Math.sin(THETA));
    assertEquals(myCartesianPoint.getX(), X);
    assertEquals(myCartesianPoint.getY(), Y);
  }
}
