package myjava.di;

public class ConfigurationFactory {

  private static final ConfigurationFactory INSTANCE = new ConfigurationFactory();

  private Configuration product;

  private ConfigurationFactory() {
    // first aproach -> ConfigurationFactory needs to be recompiled
    // this.product = new SystemPropertyConfiguration();

    // 2nd approach -> load class by configurable String (typ. String is read from XML)
    try {
      this.product = (Configuration) Class.forName("myjava.di.SystemPropertyConfiguration").newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      throw new IllegalStateException("Product not found!", e);
    }
  }

  public Configuration create() {
    return this.product;
  }

  public static final ConfigurationFactory getInstance() {
    return INSTANCE;
  }
}
