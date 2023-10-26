/**
 * 
 */
package de.mwe.dev.examples.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.mwe.dev.examples.model.listener.PersonListener;
import lombok.Data;

/**
 * @author Mars
 *
 */
@Entity
@EntityListeners(PersonListener.class)
@Data
public class Person implements Serializable {

	private static final long serialVersionUID = -3177887688232262297L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="gen")
	@SequenceGenerator(name="gen", sequenceName = "Personensequenz", initialValue = 1000, allocationSize = 10)
	private int id;
	private String vorname;
	private String nachname;
	@Temporal(TemporalType.DATE)
	private Date geburtsdatum;
	@Enumerated(EnumType.STRING)
	private Geschlecht geschlecht;
	@Lob
	private byte[] passbild;
	
	@Column(name="HINWEIS")
	private String kommentar;

	@Override
	public String toString() {
		return vorname + " " + nachname;
	}
	
}
