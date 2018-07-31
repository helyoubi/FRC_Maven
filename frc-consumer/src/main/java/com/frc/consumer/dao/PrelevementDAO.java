package com.frc.consumer.dao;


import java.util.List;

import com.frc.model.Prelevement_saisons;



public interface PrelevementDAO {

	
	public void addPrelevement(Prelevement_saisons p);
	
	public Prelevement_saisons editPrelevement(Prelevement_saisons p);
	
	public void deletePrelevement(Long id);
	
	public List<Prelevement_saisons> findAllPrelevement();
	
	public List<Object[]> attributionsBarChart();
	
	public List<Object[]> realisationsBarChart();
	
	public Prelevement_saisons findPrelevementById(Long id);
	
	public List<Object[]> realisationPersonnaliserDE(int departement,String espece);
	
	public List<Object[]> attributionPersonnaliserDE(int departement,String espece);
	
	public Object attributionMaxValue(int departement,String espece);
	
	public void importToDB(String cheminFichier);
	
}
