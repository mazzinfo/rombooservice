package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Guesture database table.
 * 
 */
@Table(name = "guesture")
@Entity(name = "Guesture")
@NamedQuery(name="Guesture.findAll", query="SELECT g FROM Guesture g")
public class Guesture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pckey")
	private int pcKey;

	@Column(name="Description")
	private String description;

	public Guesture() {
	}

	public int getPcKey() {
		return pcKey;
	}

	public void setPcKey(int pcKey) {
		this.pcKey = pcKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}