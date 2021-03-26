package com.nagarro.employeemanagerclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.employeemanagerclient.dao.HRManagerDao;
import com.nagarro.employeemanagerclient.daoImp.HRManagerDaoImp;

@Configuration
public class AppConfigDao {

	@Bean
	public HRManagerDao getHRManager() {
		return new HRManagerDaoImp();
	}
}
