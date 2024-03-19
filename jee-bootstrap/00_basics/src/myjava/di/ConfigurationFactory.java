package myjava.di;

public class ConfigurationFactory {
  
  private final static ConfigurationFactory INSTANCE = new ConfigurationFactory();

  private Configuration product;

  private ConfigurationFactory(){
    this.product = new SystemPropertyConfiguration();
  }

  public Configuration create(){
    return this.product;
  }

  public static final ConfigurationFactory getInstance(){
    return INSTANCE;
  }
}
