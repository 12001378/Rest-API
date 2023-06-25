package com.restApitoDb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restApitoDb.entity.Employee;
import com.restApitoDb.repo.EmployeeRepo;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	List<Employee> list = new ArrayList<>();
	
	public List<Employee> getAllEmployee(){
		
		List<Employee> list = this.employeeRepo.findAll();
		return list;
	}
	public Optional<Employee> getEmployeeById(int id)
	{
		Optional<Employee> emp= null;
		try {
		 emp = this.employeeRepo.findById(id);
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		return emp;
	
	}
	
	public Employee addEmployee(Employee e)
	{
		Employee add=employeeRepo.save(e);
		return add;
	}
	
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}
	
	public void updateEmployee(Employee e,int id){
		
		e.setId(id);
		employeeRepo.save(e);
	}

}
