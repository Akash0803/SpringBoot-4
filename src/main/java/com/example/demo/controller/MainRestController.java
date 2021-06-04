package com.example.demo.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.vm.EmployeeAddressVM;

@RestController
public class MainRestController {

	@Autowired
	private EmployeeService employessService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Employee> getEmployees() {
	        List<Employee> list = employessService.getEmployees();
	        return list;
	    }
	  @RequestMapping(value = "/employee/{empId}", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public Employee getEmployee(@PathVariable("empId") Long empId) {
	        Optional<Employee> emp= employessService.getEmployee(empId);
	        return emp.get();
	  }
	  
	   @RequestMapping(value = "/employee", //
	            method = RequestMethod.POST, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public ResponseEntity<EmployeeAddressVM> addEmployee(@RequestBody EmployeeAddressVM employeeAddressVM) {
	  
	        //System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo());
	  
		   return new ResponseEntity<EmployeeAddressVM>(employessService.save(employeeAddressVM),HttpStatus.OK);
	    }
	   
	   @RequestMapping(value = "/employee", //
	            method = RequestMethod.PUT, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, //
	                    MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public ResponseEntity<EmployeeAddressVM> updateEmployee(@RequestBody EmployeeAddressVM employeeAddressVM) {
	  
	    //    System.out.println("(Service Side) Editing employee with Id: " + empForm.getEmpId());
	  
		   return new ResponseEntity<EmployeeAddressVM>(employessService.save(employeeAddressVM),HttpStatus.OK);
	    }
	   @RequestMapping(value = "/employee/{empId}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	    @ResponseBody
	    public void deleteEmployee(@PathVariable("empId") Long empId) {
	  
	      //  System.out.println("(Service Side) Deleting employee with Id: " + empId);
	  
	        employessService.deleteEmployee(empId);
	    }
	
	/*
	 * 
	 *  // URL:
    // http://localhost:8080/SomeContextPath/employee/{empId}
    // http://localhost:8080/SomeContextPath/employee/{empId}.xml
    // http://localhost:8080/SomeContextPath/employee/{empId}.json
    @RequestMapping(value = "/employee/{empId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empId") Long empId) {
        return employeeDAO.getEmployee(empId);
    }
  
    // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json
  
    @RequestMapping(value = "/employee", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody EmployeeForm empForm) {
  
        System.out.println("(Service Side) Creating employee with empNo: " + empForm.getEmpNo());
  
        return employeeDAO.addEmployee(empForm);
    }
  
    // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json
    @RequestMapping(value = "/employee", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody EmployeeForm empForm) {
  
        System.out.println("(Service Side) Editing employee with Id: " + empForm.getEmpId());
  
        return employeeDAO.updateEmployee(empForm);
    }
  
    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empId}
    @RequestMapping(value = "/employee/{empId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empId") Long empId) {
  
        System.out.println("(Service Side) Deleting employee with Id: " + empId);
  
        employeeDAO.deleteEmployee(empId);
    }
  
	 */
	
	
}
