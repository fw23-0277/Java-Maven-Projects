package com.study.JPQLExample_1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_employee")
@NamedQueries({
	@NamedQuery(name  = "FindEmployeeByNamePattern" , query = "SELECT e FROM Employee e WHERE e.name LIKE :name"),
	@NamedQuery(name = "FindEmployeeByDesignation" , query = "SELECT e FROM Employee e WHERE e.designation = :designation")
})
@NamedNativeQuery(name = "FindAllEmployees", query = "SELECT  * FROM my_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "emp-name" , nullable = false , length = 30)
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private int salary;
	
	@Column(length = 30 , nullable = false)
	private String designation;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, Gender gender, int salary, String designation) {
		super();
		this.name = name;
		this.gender = gender;
		this.salary = salary;
		this.designation = designation;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + ", designation="
				+ designation + "]";
	}
	
}
