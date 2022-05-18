package com.Employee.Controler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Service.EmployeeService;
import com.Employee.pojo.Employeepojo;

@RestController
public class EmployeeControler {

	@Autowired
	private EmployeeService empservice;
	@GetMapping("Employee/{id}")
	public Optional<Employeepojo> empoption(Employeepojo pojo){
		Optional<Employeepojo> emppop= empservice.repo(pojo);
		return emppop;
	}
}
