package com.cts.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.Employee;
import com.cts.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//Testing the git
	@GetMapping
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById( @PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee){
		 return  new ResponseEntity<Employee>(employeeService.addEmployee(employee),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public String updateEmployee(@PathVariable int id,  @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}
	
	@GetMapping("/getbyname/{name}")
	public List<Employee> employeeByName(@PathVariable String name){
		return employeeService.getEmployyesByName(name);
	}

}
