package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressRepo;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Address;
import com.example.demo.model.Employee;
import com.example.demo.vm.EmployeeAddressVM;




@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private AddressRepo addressRepo;
	
	public List<Employee> getEmployees(){
		List<Employee> employees=employeeRepo.findAll();
		return employees;
	}
	
	public EmployeeAddressVM save(EmployeeAddressVM employeeAdreessVM) {
		Employee employee=employeeAdreessVM.getEmployee();
		employeeRepo.save(employee);
		for(Address address : employeeAdreessVM.getAddress()) {
			address.setEmployee(employee);
			addressRepo.save(address);
		}
		return employeeAdreessVM;
	}
	public Optional<Employee> getEmployee(Long id) {
		Optional<Employee> employee=employeeRepo.findById(id);
		return employee;
	}
	public void deleteEmployee(Long id) {
		//Optional<Employee> employee=employeeRepo.findById(id);
		employeeRepo.deleteById(id);
		//return employee;
	}
	
	//////////////////////////////
	public List<Employee> listAll() {
        return employeeRepo.findAll();
    }
     
    public void save(Employee emp) {
        employeeRepo.save(emp);
    }
     
    public Employee get(long id) {
        return employeeRepo.findById(id).get();
    }
     
    public void delete(long id) {
        employeeRepo.deleteById(id);
    }
	
}
