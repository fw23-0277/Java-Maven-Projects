package com.study.JPQL_Assignment_1;



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
		emf = Persistence.createEntityManagerFactory("player");
	}
	
	static void getPlayerNamesUpperCase() {
		try (EntityManager em = emf.createEntityManager()){
			String jpqlQuery = "SELECT UPPER(p.name) FROM Player p";
			
			Query query  = em.createQuery(jpqlQuery);
			List<String> list =  (List<String>) query.getResultList();
			
			list.stream().forEach(i ->{System.out.print(i + " ");});
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	static void getMinimumAgeOfPlayer() {
		try (EntityManager em = emf.createEntityManager()){
			String jpqlQuery = "SELECT MIN(p.age) FROM Player p";
			Query query = em.createQuery(jpqlQuery);
			
			int minAgePlayer = (int) query.getSingleResult();
			
			System.out.println(minAgePlayer);
			
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	static void getPlayerAgeBetween(int start , int end) {
		
		try (EntityManager em = emf.createEntityManager()){
			String jpqlQuery = "SELECT p FROM Player  p WHERE p.age BETWEEN :lower_range AND :upper_range";
			Query query =  em.createQuery(jpqlQuery);
			query.setParameter("lower_range",start);
			query.setParameter("upper_range",end);
			List<Player> list = (List<Player>) query.getResultList();
			
			list.stream().forEach(i -> {System.out.println(i);});
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	static void getPlayerNameStart(char ch) {
		try (EntityManager em = emf.createEntityManager()){
			String jpqlQuery = "SELECT p FROM Player p WHERE p.name LIKE :name";
			Query query =  em.createQuery(jpqlQuery);
			query.setParameter("name", ch+"%");
			List<Player> list =  (List<Player>)query.getResultList();
			list.stream().forEach(i -> {System.out.println(i);});
			
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
    public static void main( String[] args )
    {
    	
    	getPlayerNamesUpperCase();
    	getMinimumAgeOfPlayer();
    	getPlayerAgeBetween(22, 25);
    	getPlayerNameStart('r');
        
    }
}
