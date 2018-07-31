package com.frc.services;

import com.frc.consumer.dao.ChasseurLoginDAO;
import com.frc.consumer.dao.ChasseurLoginDAOImpl;

public class ChasseurLoginServicesImpl implements ChasseurLoginServices {
	

	ChasseurLoginDAO chasseurLogin = new ChasseurLoginDAOImpl();
	
	
	public boolean checkuser(String loginChasseur, String mdpChasseur) {
		
		return chasseurLogin.checkuser(loginChasseur, mdpChasseur);
		
	}


	
	
}
