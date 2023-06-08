package com.study.ui;

import java.util.Scanner;

import com.study.entity.Student;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;
import com.study.service.IStudentService;
import com.study.service.StudentServiceImpl;

public class UIMain {
	
	static void findStudentById(Scanner sc) {
		System.out.print("Enter Student Id : ");
		int id = sc.nextInt();
		
		IStudentService studentService = new StudentServiceImpl();
		try {
		  	Student student = studentService.findStudentById(id);
		  	System.out.println(student);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	static void saveStudent(Scanner sc) {
		System.out.print("Enter Student Email : ");
		String email = sc.nextLine();
		
		System.out.print("Enter Student Address : ");
		String address = sc.nextLine();
		
		
		System.out.print("Enter Student Course : ");
		String course = sc.nextLine();
		
		
		System.out.print("Enter Student Course Level :");
		int level = sc.nextInt();
		
		
		Student student = new Student(email, address, course, level);
		
		IStudentService studentService = new StudentServiceImpl();
		
		System.out.println(student);
		
		try {
			String studentSaved =  studentService.saveStudent(student);
			System.out.println(studentSaved);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	
	}
	
	
	static void deleteStudent(Scanner sc) {
		System.out.print("Enter Student Id : ");
		int id = sc.nextInt();
		
		IStudentService studentService = new StudentServiceImpl();
		try {
		  	String deleteResult  = studentService.deleteStudentById(id);
		  	System.out.println(deleteResult);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	static void updateStudent(Scanner sc) {
		System.out.print("Enter Student Id : ");
		int id = sc.nextInt();
		
		System.out.print("Enter Student Level : ");
		int level = sc.nextInt();
		
		IStudentService studentService = new StudentServiceImpl();
		
		try {
			String updateResult = studentService.updateStudentLevel(id, level);
			System.out.println(updateResult);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}


	}
		
	
	public static void shwoMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		do {
			System.out.println("1) Find Student By Id");
			System.out.println("2) Save Student Details");
			System.out.println("3) Delete Student By Id");
			System.out.println("4) Update Student By Id");
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				findStudentById(sc);
				break;
			case 2:
				saveStudent(sc);
				break;
			case 3: 
				deleteStudent(sc);
				break;
			case 4:
				updateStudent(sc);
				break;
			case 0:
				System.out.println("Thank For Using Our Services");
				break;
			default :
				System.out.println("Invalid Choice...!");
			}
			
		}while(choice != 0);
	}
}
