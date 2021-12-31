package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.EmployeeNotFoundException;
import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public List<Employee> getEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {

		return employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Empolyee with the id "+id+"does not exists"));
	}

	@Override
	public Employee addEmployee(Employee employee) {
 
		 employeeRepo.save(employee);
		 return employee;
	}

	@Override
	public String updateEmployee(int id, Employee employee) {
		Optional<Employee> optionalEmployee= employeeRepo.findById(id);
		if(!optionalEmployee.isPresent()) {
			throw new EmployeeNotFoundException("Empolyee with the id "+id+"does not exists");
		}
		
		Employee emp=optionalEmployee.get();
		if(emp.getName()!=null) {
			emp.setName(employee.getName());
		}
		
		if(emp.getGender()!=null) {
			emp.setGender(employee.getGender());
		}
		
		if(emp.getAge()!=0) {
			emp.setAge(employee.getAge());
		}
		if(emp.getSalary()!=0) {
			emp.setSalary(employee.getSalary());
		}
		
		employeeRepo.save(emp);
		
		return "Employee with the id "+id+ " updated successfully";
	}

	@Override
	public String deleteEmployee(int id) {
		Optional<Employee> optionalEmployee= employeeRepo.findById(id);
		if(!optionalEmployee.isPresent()) {
			throw new EmployeeNotFoundException("Empolyee with the id "+id+"does not exists");
		}
		employeeRepo.deleteById(id);
		return "Employee with the id "+id+ " deleted successfully";
	}

	@Override
	public List<Employee> getEmployyesByName(String name) {
		return employeeRepo.findByName(name);
	}

}
