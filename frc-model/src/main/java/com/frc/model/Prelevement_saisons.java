package com.frc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prelevement_saisons implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_prelevement;
	
	private String espece;
	
	private String saison;
	
	private int departement;
	
	private String commune;
	
	private int code;
	
	private int attributions;
	
	private int realisations;

	public Prelevement_saisons() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_prelevement() {
		return id_prelevement;
	}

	public void setId_prelevement(Long id_prelevement) {
		this.id_prelevement = id_prelevement;
	}

	public String getEspece() {
		return espece;
	}

	public void setEspece(String espece) {
		this.espece = espece;
	}

	public String getSaison() {
		return saison;
	}

	public void setSaison(String saison) {
		this.saison = saison;
	}

	public int getDepartement() {
		return departement;
	}

	public void setDepartement(int departement) {
		this.departement = departement;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAttributions() {
		return attributions;
	}

	public void setAttributions(int attributions) {
		this.attributions = attributions;
	}

	public int getRealisations() {
		return realisations;
	}

	public void setRealisations(int realisations) {
		this.realisations = realisations;
	}
	
	
	
	
	
	
	
}
