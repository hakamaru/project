package com.Employee.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Employee.Dao.EmployeeRepository;
import com.Employee.pojo.Employeepojo;

@Component
public class EmployeeService {

	@Autowired
	public EmployeeRepository emp;
	
	//Exeption
	public Optional<Employeepojo> repo(Employeepojo emppojo){
		Optional<Employeepojo> empprg= emp.findById(emppojo.getId());
	
		if(!empprg.isEmpty()) {
			throw new RuntimeException("Employee exist");
		}else {
			throw new RuntimeException("Employee doesn't exist");
		} 
	}
	
	//Sorting in desc
	
	public List<Employeepojo> getAll(){
		
		List<Employeepojo> list=(List<Employeepojo>) this.emp.findAll();
		Collections.sort(list, (d1,d2) -> Double.compare(d2.getSalary(),d1.getSalary()));
		return list;
	}
	
	//sorting name in desc if salary is same
	
	//update salary
	
	public Employeepojo update(Employeepojo pojo) {
		Employeepojo epojo=null;
		Optional<Employeepojo> optionalproject=emp.findById((int) pojo.getId());
	
		epojo=optionalproject.get();
		epojo.setSalary(pojo.getSalary());
		emp.save(epojo);
		
		
		return epojo;
	}
	
} 

