package com.nagarro.employeemanagerclient.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.employeemanagementclient.services.EmpMangService;
import com.nagarro.employeemanagementclient.services.SignService;
import com.nagarro.employeemanagerclient.dto.Employee;

@Controller
public class SignController {

	final static Logger LOG = Logger.getLogger(SignController.class);
	
	@Autowired
	SignService signservice;
	
	@Autowired
	private EmpMangService empMangService;

	@RequestMapping("/SignIn")
	public ModelAndView signIn(@RequestParam("hrmId") String hrmId,
			@RequestParam("hrmPswd") String hrmPswd) {
		LOG.info("Recieved SignIn Request by : " + hrmId);

		ModelAndView mv = new ModelAndView();

		if (signservice.validateHRManager(hrmId, hrmPswd)) {
			mv.addObject("hrmId", hrmId);
			System.out.println("hi");
			List<Employee> employees = empMangService.getEmployees();
			
			
			mv.addObject("employees", employees);
			mv.setViewName("home");
		} else {
			mv.setViewName("index");
		}

		return mv;
	}

	@RequestMapping("/SignOut")
	public ModelAndView signOut() {
		LOG.info("Recieved SignOut Request.");

		ModelAndView mv = new ModelAndView();
		mv.addObject("hrmId", null);
		mv.setViewName("index");
		return mv;
	}
}
