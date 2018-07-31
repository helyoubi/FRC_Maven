package com.frc.model;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@SessionScoped
public class Chasseurs_login implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_chasseur;
	
	private String login_chasseur;
	
	private String password_chasseur;
	
	private String permis_validite;
	
	private String 	statut_chasseur;

	public Chasseurs_login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_chasseur() {
		return id_chasseur;
	}

	public void setId_chasseur(Long id_chasseur) {
		this.id_chasseur = id_chasseur;
	}

	public String getLogin_chasseur() {
		return login_chasseur;
	}

	public void setLogin_chasseur(String login_chasseur) {
		this.login_chasseur = login_chasseur;
	}

	public String getPassword_chasseur() {
		return password_chasseur;
	}

	public void setPassword_chasseur(String password_chasseur) {
		this.password_chasseur = password_chasseur;
	}
	
	

	public String getPermis_validite() {
		return permis_validite;
	}

	public void setPermis_validite(String permis_validite) {
		this.permis_validite = permis_validite;
	}

	public String getStatut_chasseur() {
		return statut_chasseur;
	}

	public void setStatut_chasseur(String statut_chasseur) {
		this.statut_chasseur = statut_chasseur;
	}
	
	
	
	
}
