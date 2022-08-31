package de.mwe.dev.design.patterns.solid.dip;

import java.util.List;

public interface RelationshipBrowser {
	List<Person> findAllChildrenOf(String name);
}
