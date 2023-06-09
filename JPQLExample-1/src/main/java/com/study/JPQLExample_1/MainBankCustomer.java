package com.study.JPQLExample_1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class MainBankCustomer {
	
static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("my_employee");
	}
	
	static void addCustomer() {
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			em = emf.createEntityManager();
			Address officeAddress = new Address("Pune","Maharshtra",203213);
			Address homeAddress = new Address("Satara","Maharshtra",302322);
			BankCustomer bankCustomer = new BankCustomer("Rutwik",10, homeAddress,officeAddress);
//			System.out.println(bankCustomer);
			et = em.getTransaction();
			et.begin();
			em.persist(bankCustomer);
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
			BankCustomer  Bankcustomer = em.find(BankCustomer.class, 1);
			System.out.println("Name : " + Bankcustomer.getName() + ", Annual Income : " + Bankcustomer.getAnnualIncome());
			Address homeAddress = Bankcustomer.getHomeAddress();
			Address officeAddress = Bankcustomer.getOfficeAddress();
			System.out.println("Home Address : " + "City : " + homeAddress.getCity() + ", State : " + homeAddress.getState() + ", Zipcode : " + homeAddress.getZipcode());
			System.out.println("Office Address : " + "City : " + officeAddress.getCity() + ", State : " + officeAddress.getState() + ", Zipcode : " + officeAddress.getZipcode());
		} catch (PersistenceException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addCustomer();
		viewCustomerListDetails();

	}

}
