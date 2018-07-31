package com.frc.managedbean;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;


import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.frc.services.PrelevementServices;
import com.frc.services.PrelevementServicesImpl;



@ManagedBean
public class ImportFichier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private PrelevementServices prelevServ = new PrelevementServicesImpl();

	private UploadedFile file2;
	
	private String folder = "D:\\apache-tomcat-9.0.4\\Uploaded_files\\";


	public UploadedFile getFile2() {
		return file2;
	}


	public void setFile2(UploadedFile file2) {
		this.file2 = file2;
	}
	
	/*
	
	public String getUrlBase() {
	    return FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload/csv/");
	}
	
	*/
	
	public void handleFileUpload(FileUploadEvent event) {
		
        
        try (InputStream input = event.getFile().getInputstream()) {
			
			String fileName = event.getFile().getFileName();
	        
			Files.copy(input, new File(folder, fileName).toPath());
	        
	        if(fileName!= null) {
	 
				prelevServ.importToDB(folder+fileName);
				
	            FacesMessage message = new FacesMessage("Le fichier "+fileName+ " a été importé avec succès !");
	            
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            
	        }else {
	        	
	        	FacesMessage message = new FacesMessage("Le chemin du fichier : "+fileName+" est introuvable");
	            
	            FacesContext.getCurrentInstance().addMessage(null, message);
	        	
	        }
			
	        
	    }
	    catch (IOException e) {
	    	
	        e.printStackTrace();
	        
	        FacesMessage message = new FacesMessage("Le fichier existe déjà dans le serveur");
            
            FacesContext.getCurrentInstance().addMessage(null, message);
	    }
    
	}
	

	
		
	}
	
	
