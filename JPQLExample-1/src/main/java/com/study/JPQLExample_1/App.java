package com.study.JPQLExample_1;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class App {
	static EntityManagerFactory emf = null;

	static {
		emf = Persistence.createEntityManagerFactory("my_employee");
	}

	static void printEmployeeNameInupperCase() {
		EntityManager em = emf.createEntityManager();

		String UpperQuery = "SELECT UPPER(e.name) FROM Employee e";

		Query query = em.createQuery(UpperQuery);
		List<String> list = (List<String>) query.getResultList();
		for (String name : list) {
			System.out.print(name + " ");
		}
		em.close();

	}

	static void printMaximumSalary() {

		try (EntityManager em = emf.createEntityManager()) {

			String maxQuery = "SELECT MAX(e.salary) FROM Employee e";

			Query query = em.createQuery(maxQuery);
			Integer maxSalary = (Integer) query.getSingleResult();

			System.out.println("The Maximun Salary is " + maxSalary + ".");

		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	static void printEmployeeDeatilsSalaryRange(int start, int end) {

		try (EntityManager em = emf.createEntityManager()) {

			String salaryRangeQuery = "SELECT e FROM Employee e WHERE e.salary BETWEEN :lower_range AND :upper_range";
			Query query = em.createQuery(salaryRangeQuery);
			query.setParameter("lower_range", start);
			query.setParameter("upper_range", end);
			List<Employee> list = (List<Employee>) query.getResultList();
			for (Employee emp : list) {
				System.out.println(emp);
			}

		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	static void printEmployeeDeatilsCountDesignationWise() {

		try (EntityManager em = emf.createEntityManager()) {

			String designation = "SELECT e.designation ,count(e) FROM Employee e GROUP BY e.designation HAVING COUNT(e) >= 2 ORDER BY COUNT(e) DESC";
			Query query = em.createQuery(designation);
			
			List<Object[]> list = (List<Object[]>) query.getResultList();
			for (Object[] emp : list) {
				System.out.println("Designation : " + emp[0] + " Total Employee : " + emp[1]);
			}

		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	
	static void promoteClerk() {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			String updateQuery = "UPDATE Employee SET designation = :designation , salary = :salary WHERE id = :id";
			Query query = em.createQuery(updateQuery);
			query.setParameter("designation", "Sr. Clerk");
			query.setParameter("salary", 60000);
			query.setParameter("id", 1207);
			et = em.getTransaction();
			et.begin();
			query.executeUpdate();
			et.commit();
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			et.rollback();
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	}
	
	static void deleteEmployeeById() {
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = emf.createEntityManager();
			String deleteQuery = "DELETE FROM Employee WHERE id = :id";
			Query query = em.createQuery(deleteQuery);
			query.setParameter("id", 1207);
			et = em.getTransaction();
			et.begin();
			query.executeUpdate();
			et.commit();
		} catch (IllegalArgumentException | IllegalStateException e) {
			// TODO: handle exception
			et.rollback();
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	}

	static void printEmployeeDetailsForNamePattern() {
		try (EntityManager em = emf.createEntityManager()){
			Query query = em.createNamedQuery("FindEmployeeByNamePattern",Employee.class);
			query.setParameter("name", "%r%");
			List<Employee> list = (List<Employee>) query.getResultList();
			for (Employee emp : list) {
				System.out.println(emp);
			}

		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	static void printEmployees() {
		try (EntityManager em = emf.createEntityManager()){
			Query query = em.createNamedQuery("FindAllEmployees");
			
			List<Object[]> list = (List<Object[]>) query.getResultList();
			for (Object o[] : list) {
				System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3] + " " + o[4]);
			}

		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
//		printEmployeeNameInupperCase();
//		printMaximumSalary();
//		printEmployeeDeatilsSalaryRange(30000, 40000);
//		printEmployeeDeatilsCountDesignationWise();
//		promoteClerk();
//		deleteEmployeeById();
//		printEmployeeDetailsForNamePattern();
		printEmployees();

	}
}
