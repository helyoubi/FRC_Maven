package com.frc.managedbean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import org.apache.log4j.Logger;

@ManagedBean(name="frc_adminBean")
@RequestScoped
public class Frc_adminBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(PrelevementBean.class);
	
	private String login_frc;
	
	private String password_frc;
	
	private String 	statut_frc; 
	
	
	@PostConstruct
	public void initBean() {
			
		log.info("postconstruct");
		
	
		
		System.out.println("id : "+getParam("id"));
		System.out.println("opération : "+getParam("editOperation"));
		
	
		
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


	public String getParam(String name) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		
		return params.get(name);
		
	}
	
	
}
