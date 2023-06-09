package com.study.JPQl_Assignment_2;



import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

/**
 * Hello world!
 *
 */
public class App 
{
	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("customer_table");
	}
	
	static void getCustomerById(int id) {
		try (EntityManager em = emf.createEntityManager()){
			
			
			Query query =  em.createNamedQuery("FindCustomerById",Customer.class);
			query.setParameter("id", id);
			Customer customer =  (Customer) query.getSingleResult();
			System.out.println(customer);
			
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	static void getAllCustomers() {
		try (EntityManager em = emf.createEntityManager()){
			Query query =  em.createNamedQuery("FindAllCustomers");
			List<Object[]> resultList = (List<Object[]>) query.getResultList();
			for(Object o[] : resultList) {
				System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3]);
			}
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
    public static void main( String[] args )
    {
       getCustomerById(1);
       getAllCustomers();
    }
}
