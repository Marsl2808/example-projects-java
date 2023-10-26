/**
 * 
 */
package de.mwe.dev.examples.model.listener;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;

import de.mwe.dev.examples.model.Person;

/**
 * @author Mars
 *
 */
public class PersonListener {

	@PostPersist
	public void protokolliereEinfuegen(Person p) {
		System.out.println("Protokoll: Person mit id " + p.getId() + " wurde eingefuegt." );
	}
	
	@PostUpdate
	public void protokolliereUpdate(Person p) {
		System.out.println("Protokoll: Person mit id " + p.getId() + " wurde aktualisiert." );
	}
	
	@PostRemove
	public void protokolliereLoeschen(Person p) {
		System.out.println("Protokoll: Person mit id " + p.getId() + " wurde geloescht." );
	}
	
}
