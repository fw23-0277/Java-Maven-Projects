package com.study.JPQLExample_1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class CustomerMain {
	
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("my_employee");
	}
	
	static void addCustomer() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			Address address = new Address("Pune","Maharshtra",203213);
			Customer customer = new Customer("ABC",20,address);
			et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		} catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void viewCustomerListDetails() {
		try (EntityManager em = emf.createEntityManager()){
			Customer  customer = em.find(Customer.class, 1);
			System.out.println("Name : " + customer.getName() + ", Annual Income : " + customer.getAnnualIncome());
			Address address = customer.getAddress();
			System.out.println("City : " + address.getCity() + ", State : " + address.getState() + ", Zipcode : " + address.getZipcode());
			
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		addCustomer();
		viewCustomerListDetails();
		
		
	}

}
