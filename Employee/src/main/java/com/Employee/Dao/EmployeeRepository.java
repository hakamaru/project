package com.Employee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.pojo.Employeepojo;

public interface EmployeeRepository extends JpaRepository<Employeepojo, Integer> {

}
