package com.example.demo.vm;

import java.util.Set;

import com.example.demo.model.Address;
import com.example.demo.model.Employee;


public class EmployeeAddressVM {
	private Employee employee;
	private Set<Address> address;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeAddressVM [employee=" + employee + ", address=" + address + "]";
	}
	
}
