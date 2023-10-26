/**
 * 
 */
package de.mwe.dev.dpatterns.solid.dip;

import java.util.List;

/**
 * @author mars
 * high-level module: allows operations on the low-level constructs. -> higher to the end user
 */
public class Research {
  
  // problem: ctor depends on low-level module Relationships
//	public Research(Relationships relationships) {
//		List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
//		relations.stream()
//		.filter(x -> x.getValue0().name.equals("John") 
//				&& x.getValue1() == Relationship.PARENT)
//		.forEach(child -> System.out.println("John has a child called " + child.getValue2().name));
//	}
  
  // better solution, depend on abstraction
  public Research(RelationshipBrowser browser) {
    List<Person> children = browser.findAllChildrenOf("John");
    for(Person child : children) {
      System.out.println("John has a child called " + child.name);
    }
  }
}
