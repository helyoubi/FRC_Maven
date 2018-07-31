package com.frc.managedbean;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.frc.model.Prelevement_saisons;
import com.frc.services.PrelevementServices;
import com.frc.services.PrelevementServicesImpl;






//Le bloc vont s'éxécuter et seront effacer de la mémoire après l'apparition de la page xhtml , car on est en requestScoped
@ManagedBean(name="prelevementBean")
@RequestScoped
public class PrelevementBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getLogger(PrelevementBean.class);

	//Appel de l'interface services pour effectuer les différentes opérations métier
	
	private PrelevementServices pServices = new PrelevementServicesImpl();
	
	//C'est recommander que les attributs sois en type String dans  JSF au niveau d'une facelet afin d'éviter tout problème de converstion ou de champ libre

	private Prelevement_saisons selectedPrelev;
	
	private String id_prelevement;

	private String espece;
	
	private String saison;
	
	private String departement;
	
	private String commune;
	
	private String code;
	
	private String attributions;
	
	private String realisations;
	
	private List<Prelevement_saisons> prelevementList;
	
	private String success;
	
	private boolean showFormStatut = true;
	

	
	//Bloc d'initialisation static , le bloc static s'exécute une seule fois dans a la première instantiation
	//S'exécute en premier avant constructeur
	static {
				
		System.out.println("bloc static");
				
	}
	
	//Bloc d'initialisation
	{
		
		System.out.println("bloc");
		
	}
	
	
	
	//Constructeur par défaut !
	public PrelevementBean() {
		System.out.println("Constructeur");
	}
	
	
	//PostConstruct : faire un traitement dans une méthode avant d'afficher la page JSF
	//Quand JSF vas instantier cet objet ProjetBean , la première chose a faire c'est d'appeler cette méthode initBean avec le PostConstruct après l'initialisation du constructeur .
	//Exemple utilisation : initialiser un formulaire de modification de données avec les valeurs de la base de données pour les modifier par la suite en appelant la méthode merge de la partie service
	@PostConstruct
	public void initBean() {
			
		System.out.println("PostConstruct");
	
		//############Préparer prelevementList############///
		
		prelevementList = pServices.findAllPrelevement();
		
		
	}
	

	public Prelevement_saisons getSelectedPrelev() {
		return selectedPrelev;
	}


	public void setSelectedPrelev(Prelevement_saisons selectedPrelev) {
		this.selectedPrelev = selectedPrelev;
	}


	public String getId_prelevement() {
		return id_prelevement;
	}


	public void setId_prelevement(String id_prelevement) {
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


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getCommune() {
		return commune;
	}


	public void setCommune(String commune) {
		this.commune = commune;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getAttributions() {
		return attributions;
	}


	public void setAttributions(String attributions) {
		this.attributions = attributions;
	}


	public String getRealisations() {
		return realisations;
	}


	public void setRealisations(String realisations) {
		this.realisations = realisations;
	}


	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}


	public boolean isShowFormStatut() {
		return showFormStatut;
	}


	public void setShowFormStatut(boolean showFormStatut) {
		this.showFormStatut = showFormStatut;
	}
	

	public List<Prelevement_saisons> getPrelevementList() {
		return prelevementList;
	}


	public void setPrelevementList(List<Prelevement_saisons> prelevementList) {
		this.prelevementList = prelevementList;
	}


	public String getParam(String name) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		
		return params.get(name);
		
	}
	
	

	
	
	public void showForm(ActionEvent e) {
		
		log.info("Affichage du formulaire");
		showFormStatut = true;
		
	}
	
	
	public void hideForm(ActionEvent e) {
		
		log.info("Masquer le formulaire");
		showFormStatut = false;
		
	}
	
	

	
	
	
	

}
