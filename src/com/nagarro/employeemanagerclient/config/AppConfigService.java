package com.nagarro.employeemanagerclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.employeemanagementclient.services.EmpMangService;
import com.nagarro.employeemanagementclient.services.SignService;

@Configuration
public class AppConfigService {

	@Bean
	public SignService getSignService() {
		return new SignService();
	}

	@Bean
	public EmpMangService getEmpMangService() {
		return new EmpMangService();
	}
	
}
