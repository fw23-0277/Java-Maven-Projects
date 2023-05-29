package com.study.EmployeeHibernateApp;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

/**
 * Hello world!
 *
 */
public class App {
	static EntityManagerFactory entityManagerFactory = null;
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("employees");
	}
	
	static void addEmployee() {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			entityManager = entityManagerFactory.createEntityManager();
		} catch (PersistenceException e) {
			// TODO: handle exception
		}
		
	}
	
    public static void main( String[] args )
    {
    	
    	Scanner sc = new Scanner(System.in);
    	int choice;
        
    	do {
    		System.out.println("1) Add Employee");
    		System.out.println("2) Update Employee Salary Using Id");
    		System.out.println("3) Delete Employee Using ID");
    		System.out.println("4) View Employee Using Id ");
    		System.out.println("0) Close Application");
    		System.out.print("Enter Your choice ");
    		choice = sc.nextInt();
    		switch(choice) {
    		case 1 :
    			addEmployee();
    			break;
    		case 2 :
    			
    			break;
    		case 3 :
    			break;
    		case 4 :
    			break;
    		case 0 :
    			System.out.println("Thank You...!");
    			break;
    		default :
    			System.out.println("");
    			
    		}
    		
    	}while(choice != 0);
    }
}
