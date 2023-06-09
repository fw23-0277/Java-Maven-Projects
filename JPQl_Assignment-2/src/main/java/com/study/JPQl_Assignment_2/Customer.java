package com.study.JPQl_Assignment_2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "FindCustomerById", query = "SELECT c FROM Customer c WHERE id = :id")
@NamedNativeQuery(name = "FindAllCustomers", query = "SELECT * FROM  customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int  id;
	
	@Column(length = 30 , nullable =  false)
	private String name;
	
	@Column(length = 50 , nullable = false)
	private String address;
	
	@Column(length = 10 , nullable = false)
	private int budget;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String address, int budget) {
		super();
		this.name = name;
		this.address = address;
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", budget=" + budget + "]";
	}
	
}
