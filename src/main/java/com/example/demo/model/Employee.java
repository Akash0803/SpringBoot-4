package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	private Set<Address> employeeAddress;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Address> getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(Set<Address> employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", employeeAddress=" + employeeAddress + "]";
	}

	

}
