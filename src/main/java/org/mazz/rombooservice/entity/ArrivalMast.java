package org.mazz.rombooservice.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ArrivalMast database table.
 * 
 */
@Table(name = "arrivalmast")
@Entity(name = "ArrivalMast")
@NamedQuery(name="ArrivalMast.findAll", query="SELECT a FROM ArrivalMast a")
public class ArrivalMast implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "arrivalcode")
	private int arrivalCode;

	@Column(name="Description")
	private String description;

	public ArrivalMast() {
	}

	public int getArrivalCode() {
		return arrivalCode;
	}

	public void setArrivalCode(int arrivalCode) {
		this.arrivalCode = arrivalCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}