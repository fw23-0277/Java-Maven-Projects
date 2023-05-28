package com.study.ui;

import java.util.List;
import java.util.Scanner;

import com.study.dto.Lawyer;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomethingWentWrongException;
import com.study.service.ILawyerService;
import com.study.service.LawyerServiceImpl;

public class UIMain {
	static Scanner sc = new Scanner(System.in);
	
    static ILawyerService lawyerService = new LawyerServiceImpl();

	static void addLawyer() {
		System.out.print("Enter Lawyer Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Lawyer Name : ");
		String name = sc.next();
		System.out.print("Enter Lawer Email : ");
		String email = sc.next();
		System.out.print("Enter Lawyer Address :");
		String address = sc.next();
		System.out.print("Enter Lawyer Experience :");
		int exp = sc.nextInt();
		
		
		Lawyer lawyer = new Lawyer(id, name, email, address, exp);
		
		try {
			String success = lawyerService.saveLawyer(lawyer);
			
			if(success != null ) System.out.println(success);
			
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}
		
		

	}

	static void updateLawyer() {
		System.out.print("Enter Lawyer Id : ");
		int id = sc.nextInt();
		System.out.print("Enter Lawyer Experience :");
		int exp = sc.nextInt();
		
		try {
			String success = lawyerService.updateLawyerExperience(id, exp);
			if(success != null) System.out.println(success);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	static void DeleteLawyer() {
		
		System.out.print("Enter Lawyer Id : ");
		int id = sc.nextInt();
		try {
			String success = lawyerService.deleteLawyerById(id);
			if(success != null) System.out.println(success);
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	static void FindLawyer() {
		System.out.print("Enter Lawyer Id : ");
		int id = sc.nextInt();
		try {
		Lawyer	lawyer = lawyerService.findLawyerById(id);
		if(lawyer != null) System.out.println(lawyer.getId()+" "+lawyer.getName()+" "+lawyer.getEmail()+" "+lawyer.getAddress()+" "+lawyer.getExperience());
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	static void ViewAllLawyer() {
		try {
			List<Lawyer> lawyerList = lawyerService.getLawyerList();
			lawyerList.stream().forEach(System.out::println);
			
		} catch (SomethingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	
	public static void displayUIMenu() {
		String menu = """
				1) Add Lawyer
				2) Update Lawyer
				3) Delete Lawyer
				4) Find Lawyer
				5) View All Lawyer
				0) Close Application """;

		int choice;
		do {
			System.out.println(menu);
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> addLawyer();
			case 2 -> updateLawyer();
			case 3 -> DeleteLawyer();
			case 4 -> FindLawyer();
			case 5 -> ViewAllLawyer();
			case 0 -> System.out.println("Thank You...! Visit Again Our Services");
			}

		} while (choice != 0);

	}

}
