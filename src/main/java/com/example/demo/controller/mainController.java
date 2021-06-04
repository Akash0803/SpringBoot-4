package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.EmployeeService;
@Controller
public class mainController {

	@RequestMapping("/")
	public String welcome() {
	   return "index";
	}
}
