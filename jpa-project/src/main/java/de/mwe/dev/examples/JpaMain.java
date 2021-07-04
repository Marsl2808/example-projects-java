/**
 * 
 */
package de.mwe.dev.examples;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.mwe.dev.examples.model.Person;

/**
 * @author Mars
 *
 */
public class JpaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-project");
		EntityManager em = emf.createEntityManager();
		
		Person p = new Person();
		p.setVorname("Max");
		p.setNachname("Mustermann");
		
		em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
	}

}
