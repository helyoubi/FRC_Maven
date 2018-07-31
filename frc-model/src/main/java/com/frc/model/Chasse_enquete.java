package com.frc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chasse_enquete implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_enquete;
	
	private String autre_espece_statut;
	
	private int departement_chasse;
	
	private String espece_chasse;
	
	private String mois_chasse;
	
	private int id_chasseur_enquete;

	public Chasse_enquete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_enquete() {
		return id_enquete;
	}

	public void setId_enquete(Long id_enquete) {
		this.id_enquete = id_enquete;
	}

	public String getAutre_espece_statut() {
		return autre_espece_statut;
	}

	public void setAutre_espece_statut(String autre_espece_statut) {
		this.autre_espece_statut = autre_espece_statut;
	}

	public int getDepartement_chasse() {
		return departement_chasse;
	}

	public void setDepartement_chasse(int departement_chasse) {
		this.departement_chasse = departement_chasse;
	}

	public String getEspece_chasse() {
		return espece_chasse;
	}

	public void setEspece_chasse(String espece_chasse) {
		this.espece_chasse = espece_chasse;
	}

	public String getMois_chasse() {
		return mois_chasse;
	}

	public void setMois_chasse(String mois_chasse) {
		this.mois_chasse = mois_chasse;
	}

	public int getId_chasseur_enquete() {
		return id_chasseur_enquete;
	}

	public void setId_chasseur_enquete(int id_chasseur_enquete) {
		this.id_chasseur_enquete = id_chasseur_enquete;
	}
	
	
	
	
}
