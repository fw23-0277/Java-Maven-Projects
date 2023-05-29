package com.study;

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
		entityManagerFactory = Persistence.createEntityManagerFactory("studentConnect");
	}
	
	static void insertStudent(Student student) {
		EntityManager entityManager  = null;
		EntityTransaction transaction = null;
		
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(student);
			transaction.commit();
			System.out.println("Student Added Succesfully...!");
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			transaction.rollback();
		}finally {
			entityManager.close();
		}
		
		
		
	}	
	
	static void findStudent(int roll) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Student student =  entityManager.find(Student.class, roll);
		if(student == null) {
			System.out.println("Student Not Found...!");
		}
		System.out.println(student);
		entityManager.close();
	}
	
	static void deleteStudent(int roll) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Student student = entityManager.find(Student.class,roll);
			if(student == null) {
				System.out.println("Student Not Found.");
				return;
			}
			
			entityManager.remove(student);
			transaction.commit();
			System.out.println("Student Delete Succsesfully.");
		} catch (PersistenceException e) {
			System.out.println(e.getMessage());
			transaction.rollback();
		}finally {
			entityManager.close();
		}
	}
	
	static void updateName(int roll,String name) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Student student = entityManager.find(Student.class,roll);
			if(student == null) {
				System.out.print("Student Not Found...!");
				return;
			}
			student.setName(name);
			transaction.commit();
			System.out.println("Student Update Succsesfully...!");
			
		} catch (PersistenceException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			transaction.rollback();
			
		}
	}
	
    public static void main( String[] args ){
       
        Scanner sc = new Scanner(System.in);
        int choice;
    			
		do {
			System.out.println("1) Add Student");
			System.out.println("2) View Student by Roll Number");
			System.out.println("3) Update Student Name by Roll Number");
			System.out.println("4) Delete Student by Roll Number ");
			System.out.println("0) Exit");
			System.out.print("Enter Your Choice :");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.print("Enter Student Roll No. : ");
					int rollNo = sc.nextInt();
					System.out.print("Enter Student Name : ");
					String name = sc.next();
					System.out.print("Enter Student Mraks : ");
					int marks = sc.nextInt();
					insertStudent(new Student(rollNo, name, marks));
					break;
				case 2 :
					System.out.print("Enter Student Roll No. : ");
					int rollNoSearch = sc.nextInt();
					findStudent(rollNoSearch);
					break;
				case 3 :
					System.out.print("Enter Student Roll No. : ");
					rollNo = sc.nextInt();
					System.out.print("Enter Student Name : ");
					name = sc.next();
					updateName(rollNo, name);
					break;
				case 4 :
					System.out.print("Enter Student Roll No. : ");
					int rollNoDelete = sc.nextInt();
					deleteStudent(rollNoDelete);
					break;
				case 0 :
					System.out.println("Visit Again");
					break;
				default :
					System.out.println("Invalid Choice");
					
						
			}
			
		}while(choice != 0);
    	
       
        
        
        
    }
}
