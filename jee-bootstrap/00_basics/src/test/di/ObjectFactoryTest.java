package test.di;

import static org.junit.Assert.assertNotNull;

import myjava.di.Configuration;
import myjava.di.ObjectFactory;

import org.junit.Before;
import org.junit.Test;

public class ObjectFactoryTest {

  private ObjectFactory cut;

  @Before
  public void init(){
    this.cut = ObjectFactory.getInstance();
  }

  @Test
  public void testCreate() {
    Configuration product = (Configuration) this.cut.create();
    assertNotNull(product);
  }
}
