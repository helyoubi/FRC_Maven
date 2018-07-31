package com.frc.services;


import java.util.List;

import com.frc.consumer.dao.PrelevementDAO;
import com.frc.consumer.dao.PrelevementDAOImpl;
import com.frc.model.Prelevement_saisons;



public class PrelevementServicesImpl implements PrelevementServices {

	//ON ne doit pas appeler l'objet session de session factory , sinn il y aura une communication directe entre la couche m�tier qui est service et la couche de la bd ce qui est faux
	
	PrelevementDAO progdao = new PrelevementDAOImpl();
	
	
	public void addProjet(Prelevement_saisons p) {
		
		progdao.addPrelevement(p);
	}

	
	public Prelevement_saisons editProjet(Prelevement_saisons p) {
		
		//Ici par exemple : on implemente le code pour un traitement métier du client , avant de modifier les attribut de la classe Projet comme exemple :
	    //Faire une copier avant de modifier la tablea Projet ou envoyer une notification avant de modifier ..
		
		return progdao.editPrelevement(p);
	}

	
	public void deleteProjet(Long id) {
		
		progdao.deletePrelevement(id);

	}

	
	public List<Prelevement_saisons> findAllPrelevement() {
		
		return progdao.findAllPrelevement();
	}

	
	public Prelevement_saisons findProjetById(Long id) {
		
		return progdao.findPrelevementById(id);
	}

	
	public List<Object[]> attributionsBarChart() {
		
		return progdao.attributionsBarChart();
	}
	
	
	public List<Object[]> realisationsBarChart() {
		
		return progdao.realisationsBarChart();
	}

	
	public List<Object[]> realisationPersonnaliserDE(int departement, String espece) {
		
		return progdao.realisationPersonnaliserDE(departement, espece);
	}

	
	public List<Object[]> attributionPersonnaliserDE(int departement, String espece) {
		
		return progdao.attributionPersonnaliserDE(departement, espece);
	}

	
	public Object attributionMaxValue(int departement, String espece) {
		
		return progdao.attributionMaxValue(departement, espece);
	}

	
	public void importToDB(String cheminFichier) {
		
		progdao.importToDB(cheminFichier);
		
	}

}
