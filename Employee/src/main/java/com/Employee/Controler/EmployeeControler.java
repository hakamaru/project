package com.Employee.Controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Service.EmployeeService;
import com.Employee.pojo.Employeepojo;

@RestController
public class EmployeeControler {

	@Autowired
	private EmployeeService empservice;
	@GetMapping("Employee/{id}")
	public ResponseEntity<Employeepojo> empoption(Employeepojo pojo) throws RuntimeException{
		
		// Optional<Employeepojo> emppop= empservice.repo(pojo);
		try {
			return new ResponseEntity( empservice.repo(pojo), HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity( e.getMessage(), HttpStatus.CONFLICT);
		}
		
		
			
		
	}
	
	@GetMapping("/Employeesalary")
	public List<Employeepojo> getsalary(){
		
		List<Employeepojo> list=empservice.getAll();
		return list;
		}
	
	@PutMapping("Employee/update")
	public Employeepojo update(@RequestBody Employeepojo emppojo) {
		return empservice.update(emppojo);
	}
	
	
	@GetMapping("Employeesalary/{id}")
	public Optional<Employeepojo> newemp(Employeepojo pojo){
		Optional<Employeepojo> emppop= empservice.repo(pojo);
		return emppop;
	}
	
	
	
}
