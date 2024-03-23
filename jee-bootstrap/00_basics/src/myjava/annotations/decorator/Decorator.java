package myjava.annotations.decorator;

import java.lang.reflect.Proxy;

public class Decorator {

  private Decorator() {
  }

  public static Object decorate(Object toDecorate) {
    Class<? extends Object> clazz = toDecorate.getClass();
    return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new LoggingAspect(toDecorate));
  }
}
