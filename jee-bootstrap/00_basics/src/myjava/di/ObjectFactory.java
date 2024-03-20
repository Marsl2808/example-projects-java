package myjava.di;

public class ObjectFactory {

  private static final ObjectFactory INSTANCE = new ObjectFactory();

  private Object product;

  private ObjectFactory() {
    // first aproach -> ConfigurationFactory needs to be recompiled
    // this.product = new SystemPropertyConfiguration();

    // 2nd approach -> load class by configurable String (typ. String is read from XML)
    try {
      this.product = Class.forName("myjava.di.SystemPropertyConfiguration").newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      throw new IllegalStateException("Product not found!", e);
    }
  }

  public Object create() {
    return this.product;
  }

  public static final ObjectFactory getInstance() {
    return INSTANCE;
  }
}
