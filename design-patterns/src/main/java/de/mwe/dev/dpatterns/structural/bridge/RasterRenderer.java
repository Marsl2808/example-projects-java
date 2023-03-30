package de.mwe.dev.dpatterns.structural.bridge;

public class RasterRenderer implements Renderer {

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for a circle of radius " + radius);
    }
}
