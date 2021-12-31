package com.cts.service;

import java.util.List;

import com.cts.model.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees();
	
	Employee getEmployeeById(int id);
	
	Employee addEmployee(Employee employee);
	
	String updateEmployee(int id , Employee employee);
	
	String deleteEmployee(int id);
	
	List<Employee> getEmployyesByName(String name);

}
