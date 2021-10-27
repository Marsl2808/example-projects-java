package mwe.dev.examples.ressources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.metrics.annotation.Timed;

import de.mwe.dev.examples.model.Geschlecht;
import de.mwe.dev.examples.model.Person;
import de.mwe.dev.examples.model.PersonDAO;

/**
 *
 */
@Path("example")
@Singleton
@Timed
public class ExampleApp {

    @GET
    @Path("/hello")
    public String sayHello() {
        return "["
        		+ "{"
        		+ "\"first:\": Hello,"
        		+ "\"second\": World"
        		+ "}"        		
        		+"]";
    }
    
    @GET
    @Path("/testdb")
    public String testDb() {
    	
		PersonDAO personDao = new PersonDAO();
		Person p = new Person();
		
		p.setVorname("Max");
		p.setNachname("Mustermann");
		
		p.setGeschlecht(Geschlecht.MAENNLICH);
		
		p.setKommentar("Testkommentar_neu");
		
		personDao.persist(p);
				
		personDao.shutdown();
    	
    	return "test";
    }
}
