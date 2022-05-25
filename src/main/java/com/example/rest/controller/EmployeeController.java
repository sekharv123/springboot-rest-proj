package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.entity.Employee;
import com.example.rest.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// add emp
	@PostMapping(path = { "/addEmp" })
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		System.out.println("Inside addEmp()");
		Employee employee = employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	// update emp
	@PostMapping(path = { "/updateEmp" })
	public Employee updateEmployee(@RequestBody Employee emp) {
		Employee employee = employeeService.updateEmployee(emp);
		return employee;
	}

	// retrieve emp
	@GetMapping(path = { "/getEmp/{empId}" })
	public Employee getEmployee(@PathVariable(name = "empId") Integer emplId) {
		Employee employee = employeeService.getEmployee(emplId);
		return employee;
	}

	// retrieve all emp
	@GetMapping(path = { "/getAllEmp" })
	public List<Employee> getAllEmp() {
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return allEmployees;
	}

	// delete emp
	@GetMapping(path = { "/deleteEmp/{empId}" })
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "empId") Integer emplId) {
		employeeService.deleteEmployee(emplId);
		return new ResponseEntity<String>("Employee with ID=" + emplId + " deleted", HttpStatus.OK);
	}

}
