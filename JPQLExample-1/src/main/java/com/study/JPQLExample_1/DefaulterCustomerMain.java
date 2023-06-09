package com.study.JPQLExample_1;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class DefaulterCustomerMain {

static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("my_employee");
	}
	
	static void addDefaulterCustomer() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			Address officeAddress = new Address("Pune","Maharshtra",203213);
			Address homeAddress = new Address("Satara","Maharshtra",302322);
			DefaluterCustomer customer  = new DefaluterCustomer("Ankit" ,15,new HashSet<Address>());
			customer.getAddressSet().add(homeAddress);
			customer.getAddressSet().add(officeAddress);
			et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
		} catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void viewCustomerListDetails() {
		try (EntityManager em = emf.createEntityManager()){
			DefaluterCustomer  customer = em.find(DefaluterCustomer.class, 1);
			System.out.println("Name : " + customer.getName() + ", Annual Income : " + customer.getAnnualIncome());
			 Set<Address> addressSet = customer.getAddressSet();
			 
			 for(Address address : addressSet) {
				 System.out.println("Home Address : " + "City : " + address.getCity() + ", State : " + address.getState() + ", Zipcode : " + address.getZipcode());
			 }
		
//			System.out.println("Office Address : " + "City : " + officeAddress.getCity() + ", State : " + officeAddress.getState() + ", Zipcode : " + officeAddress.getZipcode());
		} catch (PersistenceException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addDefaulterCustomer();
		viewCustomerListDetails();

	}

}
