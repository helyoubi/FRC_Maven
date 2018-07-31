package com.frc.managedbean;

import java.io.Serializable;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.frc.consumer.util.SessionUtils;
import com.frc.services.ChasseurLoginServices;
import com.frc.services.ChasseurLoginServicesImpl;



@ManagedBean(name="chasseur_loginBean")
@SessionScoped
public class Chasseur_loginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(PrelevementBean.class);
	
	private String login_chasseur;
	
	private String password_chasseur;
	
	private String 	statut_chasseur;
	
	private boolean remembre = false;
	
	private ChasseurLoginServices chasseurService = new ChasseurLoginServicesImpl();
	
	
	@PostConstruct
	public void initBean() {
			
		log.info("postconstruct chasseurLogin");

		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null) {
			
			for (Cookie cookie : cookies) {
				
				if(cookie.getName().equals("loginChassCookie")) {
					login_chasseur = cookie.getValue();
				}
				
			}
		}
	
		
	}
	
	  	//validate login
	
		public String validateUsernamePassword() {
			
			boolean valid = chasseurService.checkuser(login_chasseur, password_chasseur);
			
			if (valid) {
						
				if(this.remembre) {
						
					FacesContext facesContext = FacesContext.getCurrentInstance();
					
					HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
					
					Cookie cookie = new Cookie("loginChassCookie", login_chasseur);
					
					cookie.setMaxAge(60 * 60 * 24 * 30);
					
					response.addCookie(cookie);
				
				}
				

				HttpSession session = SessionUtils.getSession();
				session.setAttribute("loginChasseur", login_chasseur);
				
				return "chasseurCorrect";
				
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_WARN,
								"Identifiant ou mot de passe incorrect",
								""));
				return "login";
			}
		}




		//logout event, invalidate session
		public String logout() {
			HttpSession session = SessionUtils.getSession();
			session.invalidate();
			return "login";
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



	public String getStatut_chasseur() {
		return statut_chasseur;
	}



	public void setStatut_chasseur(String statut_chasseur) {
		this.statut_chasseur = statut_chasseur;
	}


	public boolean isRemembre() {
		return remembre;
	}

	public void setRemembre(boolean remembre) {
		this.remembre = remembre;
	}

	public String getParam(String name) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		
		return params.get(name);
		
	}
	
	
	
}
