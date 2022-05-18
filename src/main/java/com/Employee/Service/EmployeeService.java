package com.Employee.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Employee.Dao.EmployeeRepository;
import com.Employee.pojo.Employeepojo;

@Component
public class EmployeeService {

	@Autowired
	public EmployeeRepository emp;
	
	public Optional<Employeepojo> repo(Employeepojo emppojo){
		Optional<Employeepojo> empprg= emp.findById(emppojo.getId());
	
		try {
			if(empprg.isPresent()) {}
		
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		return empprg;
	}
	
}
