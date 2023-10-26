package de.mwe.dev.dpatterns.structural.bridge;

import org.junit.jupiter.api.Test;

public class RendererTest {
    @Test
    void testRenderCircle() {
        RasterRenderer rasterRenderer = new RasterRenderer();
        VectorRenderer vectorRenderer = new VectorRenderer();
        Circle circle = new Circle(vectorRenderer, 5.0f);
        circle.draw();
        circle.resize(2);
        circle.draw();

        Circle circle2 = new Circle(rasterRenderer, 3.0f);
        circle2.draw();

        // use cdi for injection s.t. single point in application exists where to choose the renderer
    }
}
