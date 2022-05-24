package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
