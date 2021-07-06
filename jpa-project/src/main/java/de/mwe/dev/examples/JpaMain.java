/**
 * 
 */
package de.mwe.dev.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

import de.mwe.dev.examples.model.Geschlecht;
import de.mwe.dev.examples.model.Person;
import de.mwe.dev.examples.model.PersonDAO;

/**
 * @author Mars
 *
 */
public class JpaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PersonDAO personDao = new PersonDAO();
		Person p = new Person();
		
		p.setVorname("Max");
		p.setNachname("Mustermann");
		
		Calendar cal = Calendar.getInstance();
		cal.set(1975,Calendar.MARCH,15);
		p.setGeburtsdatum(cal.getTime());
		
		p.setGeschlecht(Geschlecht.MAENNLICH);
		
		try {

			// TODO: use relative path (only running on local machine)
			
			//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//			URL url = ClassLoader.getSystemResource("maxmustermann.png");
//			System.out.println(url.getPath());
//			
//			Path path = Paths.get("maxmustermann.png");
//			System.out.println(path.getFileName());
			
			p.setPassbild(Files.readAllBytes(Paths.get("D:\\DEV\\java\\default\\example-projects-java\\jpa-project\\src\\main\\resources\\maxmustermann.png")));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.setKommentar("Testkommentar");
		
		personDao.persist(p);
		
		//update
		p.setVorname("Martin");
		
		personDao.persist(p);
		
		personDao.shutdown();
		
	}

}
