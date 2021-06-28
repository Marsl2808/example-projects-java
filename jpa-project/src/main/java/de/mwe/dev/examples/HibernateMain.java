/**
 * 
 */
package de.mwe.dev.examples;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import de.mwe.dev.examples.model.Person;

/**
 * @author Mars
 *
 */
public class HibernateMain {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate !!!");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		Session session=cfg.buildSessionFactory().openSession();
		
		session.beginTransaction();
		
		Person a = new Person();
		a.setVorname("12");
		session.save(a);
		
		session.getTransaction().commit();
		session.close();
	}

}
