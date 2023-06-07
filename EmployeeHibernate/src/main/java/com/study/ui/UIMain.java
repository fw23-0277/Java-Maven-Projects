package com.study.ui;

import java.math.BigDecimal;
import java.util.Scanner;

import com.study.entity.Employee;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;
import com.study.service.EmployeeServiceImpl;
import com.study.service.IEmployeeService;

public class UIMain {

	static void addEmployee(Scanner sc) {
		System.out.print("Enter Employee Name : ");
		String name = sc.nextLine();

		System.out.print("Enter Employee Address : ");
		String address = sc.nextLine();

		System.out.print("Enter Employee Salary  : ");
		BigDecimal salary = new BigDecimal(sc.nextDouble());

		IEmployeeService employeeServie = new EmployeeServiceImpl();

		try {
			Employee employee = new Employee(name, address, salary);
			employeeServie.save(employee);
			System.out.println(employee);
			System.out.println("Employee Saveed Succeesfully.");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	static void GetAddressOfEmployee(Scanner sc) {
		System.out.print("Enter Empoyee Id : ");
		int id = sc.nextInt();

		IEmployeeService employeeService = new EmployeeServiceImpl();

		try {
			String address = employeeService.getAddressOfEmployee(id);
			System.out.println(address);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	static void deleteEmployee(Scanner sc) {
		System.out.print("Enter Empoyee Id : ");
		int id = sc.nextInt();

		IEmployeeService employeeService = new EmployeeServiceImpl();
		

		try {
			boolean success  = employeeService.deleteEmployee(id);
			if(success) {
				System.out.println("Employee Delted Successfully.");
			}else {
				throw new SomethingWentWrongException("Oops...! Unable to Delete Employee.");
			}
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	static public void showUIMenu() {
		Scanner sc = new Scanner(System.in);

		int choice;

		do {
			System.out.println("1) Save Empployee");
			System.out.println("2) Get Address Of Employee Uisng Id");
			System.out.println("3) Give Bounce to Employee Using Id");
			System.out.println("4) Delete Employee");
			System.out.println("0) Exit");
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				addEmployee(sc);
				break;
			case 2:
				GetAddressOfEmployee(sc);
				break;
			case 3:
//				GiveBouncetoEmployee();
				break;
			case 4:
				deleteEmployee(sc);
				break;
			case 0:
				System.out.println("Thank You For Using Our Services.");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while (choice != 0);
	}

}
