/**
 * 
 */
package de.mwe.dev.dpatterns.solid.dip;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author mars
 *
 */
class RelationshipResearchTest {

  @Test
  void test() {
    Person parent = new Person("John");
    Person child = new Person("elsbeth");
    Person child1 = new Person("chris");
    
    Relationships relationships = new Relationships();
    relationships.addParentAndChild(parent, child);
    relationships.addParentAndChild(parent, child1);
    
    new Research(relationships);
    assertTrue(true);
  }

}
