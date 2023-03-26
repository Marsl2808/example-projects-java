package de.mwe.dev.dpatterns.creational.builder.html;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class HtmlBuilderTest {
  @Test
  void testBuild() {
    String html = new HtmlBuilder("ul")
        .addChild("li", "hello")
        .addChild("li", "world")
        .build();

    assertNotNull(html);
    System.out.println(html);
  }
}
