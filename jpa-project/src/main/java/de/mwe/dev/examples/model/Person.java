/**
 * 
 */
package de.mwe.dev.examples.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author Mars
 *
 */
@Entity
@Data
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String vorname;
	private String nachname;
	
}
