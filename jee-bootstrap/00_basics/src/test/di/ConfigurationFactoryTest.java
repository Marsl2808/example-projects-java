package test.di;

import static org.junit.Assert.assertNotNull;

import myjava.di.Configuration;
import myjava.di.ConfigurationFactory;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationFactoryTest {

  private ConfigurationFactory cut;

  @Before
  public void init(){
    this.cut = ConfigurationFactory.getInstance();
  }

  @Test
  public void testCreate() {
    Configuration product = this.cut.create();
    assertNotNull(product);
  }
}
