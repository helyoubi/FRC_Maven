package com.frc.consumer.util;



import com.frc.consumer.dao.PrelevementDAO;
import com.frc.consumer.dao.PrelevementDAOImpl;


public class Test {

	
	private static PrelevementDAO prelevServ = new PrelevementDAOImpl();
	
	public static void main(String[] args) {
	
		Object valueMax = prelevServ.attributionMaxValue(40, "CH");
		
		System.out.println("valeur max attrib est : "+valueMax);
		
	
	}

}
