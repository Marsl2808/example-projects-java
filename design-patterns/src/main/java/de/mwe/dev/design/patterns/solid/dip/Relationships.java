/**
 * 
 */
package de.mwe.dev.design.patterns.solid.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

/**
 * @author mars
 * low-level module, because related to data storage (no business logic of its own)
 * it simply allows you to manipulate the list (SRP)
 * 
 * -> Core functionality should happen in the low-level module (findAllChildrenOf())
 */
public class Relationships implements RelationshipBrowser{
	private List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();
	
	public List<Triplet<Person, Relationship, Person>> getRelations() {
		return relations;
	}

	public void addParentAndChild(Person parent, Person child) {
		relations.add(new Triplet<>(parent, Relationship.PARENT, child));
		relations.add(new Triplet<>(child, Relationship.CHILD, parent));
	}

	@Override
	public List<Person> findAllChildrenOf(String name) {		
		return relations.stream()
				.filter(x -> x.getValue0().name.equals("John") 
						&& x.getValue1() == Relationship.PARENT)
				.map(Triplet::getValue2)
				.collect(Collectors.toList()); 
	}
}
