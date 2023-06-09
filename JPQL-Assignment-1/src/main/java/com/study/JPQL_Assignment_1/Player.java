package com.study.JPQL_Assignment_1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 20, nullable = false)
	private String name;
	
	@Column(length = 40 , nullable = false,name = "sport_name")
	private String sportName;
	
	@Column(length = 3 , nullable = false)
	private int age;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Player(String name, String sportName, int age) {
		super();
		this.name = name;
		this.sportName = sportName;
		this.age = age;
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

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", sportName=" + sportName + ", age=" + age + "]";
	}
	
	
	
}
