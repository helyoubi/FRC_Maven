package com.frc.consumer.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.frc.consumer.util.HibernateUtil;

public class ChasseurLoginDAOImpl implements ChasseurLoginDAO{

	
	Session session = HibernateUtil.openSession();
	

	public boolean checkuser(String loginChasseur,String mdpChasseur) {

		Transaction tx = session.beginTransaction();

		try {
		
			
			Query query=session.createQuery("from Chasseurs_login where login_chasseur=:login_name and password_chasseur=:password");
		    
			query.setString("login_name", loginChasseur);
		  
			query.setString("password", mdpChasseur);
		  
			List list=query.list();
			
			tx.commit();
			
			if(list.size()==1){
				
	            return true;
		      
			}else{
		         
				return false;
		    }
		
	
	} catch (Exception e) {
		
		tx.rollback();
        System.out.println(e);
        e.printStackTrace();
    }
    
    return false;
    
	}

}
