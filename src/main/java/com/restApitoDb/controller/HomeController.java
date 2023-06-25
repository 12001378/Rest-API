package com.restApitoDb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApitoDb.entity.Employee;
import com.restApitoDb.service.EmployeeService;

@RestController
public class HomeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployee() {

		List<Employee> list = employeeService.getAllEmployee();
		if (list.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") int id) {
		Optional<Employee> emp = employeeService.getEmployeeById(id);

		if (emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));

	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee e) {
		Employee e1 = null;
		try {
			e1 = this.employeeService.addEmployee(e);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception ee) {
			ee.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") int id) {

		try {
			this.employeeService.deleteEmployee(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
		try {
			if (emp.getId() == id) {
				this.employeeService.updateEmployee(emp, id);
				return ResponseEntity.ok().body(emp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		

	}

}
