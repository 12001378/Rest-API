package com.restApitoDb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApitoDb.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
	


}
