package com.study.JPQLExample_1;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private double annualIncome;
	
	@Embedded
	private Address address;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, double annualIncome, Address address) {
		super();
		this.name = name;
		this.annualIncome = annualIncome;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", annualIncome=" + annualIncome + ", address=" + address
				+ "]";
	}
	
	
	
	
}
