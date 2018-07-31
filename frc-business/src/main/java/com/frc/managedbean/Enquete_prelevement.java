package com.frc.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.frc.model.Chasse_enquete;
import com.frc.model.Chasseurs_login;


@ManagedBean
public class Enquete_prelevement {
	
	private Chasse_enquete chasse_enquete = new Chasse_enquete();
	
	private Chasseurs_login chasseurs_login = new Chasseurs_login();

	public Enquete_prelevement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@PostConstruct
    public void init() {
     
      
    }

	public Chasse_enquete getChasse_enquete() {
		return chasse_enquete;
	}

	public void setChasse_enquete(Chasse_enquete chasse_enquete) {
		this.chasse_enquete = chasse_enquete;
	}

	public Chasseurs_login getChasseurs_login() {
		return chasseurs_login;
	}

	public void setChasseurs_login(Chasseurs_login chasseurs_login) {
		this.chasseurs_login = chasseurs_login;
	}
	
	

}
