package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeRepository;

@RestController
public class SBController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/getString")
	public ResponseEntity<String> getString(){
	
		return new ResponseEntity<String>("This is accessing from GCP Instance space...", HttpStatus.OK);
	}
	
	@GetMapping("/get-employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity(employeeRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/save-employee")
	public ResponseEntity<List<Employee>> addNewEmployee(@RequestBody Employee emp) {
		employeeRepository.save(emp);
		return new ResponseEntity(employeeRepository.findAll(), HttpStatus.OK);
	}
}
 