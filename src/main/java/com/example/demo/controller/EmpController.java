package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.vm.EmployeeAddressVM;

@RestController
@RequestMapping("/api")
public class EmpController {
	@Autowired
	private EmployeeService employessService;
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> get() {
		List<Employee> employees=employessService.getEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<EmployeeAddressVM> create(@RequestBody EmployeeAddressVM employeeAddressVM){
		return new ResponseEntity<EmployeeAddressVM>(employessService.save(employeeAddressVM),HttpStatus.OK);
	}
	@GetMapping("/")
	public String gete() {
		return "index";
	}
}
