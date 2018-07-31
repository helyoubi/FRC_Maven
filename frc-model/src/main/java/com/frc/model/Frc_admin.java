package com.frc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frc_admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_frc_admin;
	
	private String login_frc;
	
	private String password_frc;
	
	private String 	statut_frc;

	public Frc_admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_frc_admin() {
		return id_frc_admin;
	}

	public void setId_frc_admin(Long id_frc_admin) {
		this.id_frc_admin = id_frc_admin;
	}

	public String getLogin_frc() {
		return login_frc;
	}

	public void setLogin_frc(String login_frc) {
		this.login_frc = login_frc;
	}

	public String getPassword_frc() {
		return password_frc;
	}

	public void setPassword_frc(String password_frc) {
		this.password_frc = password_frc;
	}

	public String getStatut_frc() {
		return statut_frc;
	}

	public void setStatut_frc(String statut_frc) {
		this.statut_frc = statut_frc;
	}
	
	
	
	
}
