package com.nagarro.employeemanagerclient.daoImp;

import org.hibernate.Session;

import com.nagarro.employeemanagerclient.config.HibernateConfig;
import com.nagarro.employeemanagerclient.dao.HRManagerDao;
import com.nagarro.employeemanagerclient.dto.HRManager;

public class HRManagerDaoImp implements HRManagerDao {
	
	public HRManager getHRManager(String hrmId) {
		Session session = HibernateConfig.getSessionFactory().openSession();
		
		HRManager hrmObject = session.get(HRManager.class, hrmId);
		
		session.close();
		
		return hrmObject;
	}

}
