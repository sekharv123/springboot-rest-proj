package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Employee;
import com.example.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee emp) {
		Employee employee = employeeRepository.save(emp);
		return employee;
	}

	public Employee updateEmployee(Employee emp) {
		Employee employee = null;
		Optional<Employee> optEmp = employeeRepository.findById(emp.getId());
		if (optEmp.isPresent()) {
			employee = optEmp.get();
			employee.setEmpSal(emp.getEmpSal());
			employee.setEmpName(emp.getEmpName());
			employee.setDepartment(emp.getDepartment());
		}
		Employee savedEmp = employeeRepository.save(employee);
		return savedEmp;
	}

	public Employee getEmployee(Integer id) {
		Optional<Employee> optEmp = employeeRepository.findById(id);
		return optEmp.get();
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public void deleteEmployee(Integer emplId) {
		employeeRepository.deleteById(emplId);
	}

}
