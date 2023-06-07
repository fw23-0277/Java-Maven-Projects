package com.study.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import com.study.entity.Book;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomehingWentWrongException;
import com.study.service.BookServiceImpl;
import com.study.service.IBookService;

import jakarta.persistence.PersistenceException;

public class UIMain {
	
	static void addBook(Scanner sc) {
		System.out.print("Enter Title : ");
		String title = sc.nextLine();
		
		System.out.print("Enter Author : ");
		String author = sc.nextLine();
		
		System.out.print("Enter Price : ");
		BigDecimal price = new BigDecimal(sc.nextLine());

		
		System.out.print("Enter Publish Date [ yyyy-mm-dd ] : ");
		LocalDate publishDate = LocalDate.parse(sc.next());
		
		IBookService bookService = new BookServiceImpl();
		
		try {
			Book book = new Book(title, author, price, publishDate);
			System.out.println(book);
			bookService.addBook(book);
			System.out.println("Book Added Successfully...!");
		} catch (SomehingWentWrongException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	static void findBookId(Scanner sc){
		System.out.print("Enter Book Id : ");
		int id = sc.nextInt();
		
		try {
			IBookService bookService = new BookServiceImpl();
			Book book =  bookService.getBookById(id);
			
			System.out.println(book);
		} catch(SomehingWentWrongException | NoRecordFoundException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	static void updateBookPriceById(Scanner sc) {
		System.out.print("Enter Book Id : ");
		int id = sc.nextInt();
		
		System.out.print("Enter Book Price : ");
		BigDecimal price = new BigDecimal(sc.nextDouble());
		
		IBookService bookService = new BookServiceImpl();
		try {
			bookService.updateBookPrice(id, price);
			System.out.println("Book Updated Successfully.");
		} catch (SomehingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	static void deleteBookById(Scanner sc) {
		System.out.print("Enter Book Id : ");
		int id = sc.nextInt();
		
		IBookService bookService = new BookServiceImpl();
		
		try {
			bookService.deleteBookById(id);
			System.out.println("Book Delated Successfully.");
		} catch (SomehingWentWrongException | NoRecordFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void showUIMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		
		do {
			System.out.println("1) Add Book");
			System.out.println("2) View Book By Id");
			System.out.println("3) Update Book By Id");
			System.out.println("4) Delete Book By Id");
			System.out.println("0) Application Close");
			System.out.print("Enter Your Choice : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1 :
				addBook(sc);
				break;
			case 2 :
				findBookId(sc);
				break;
			case 3 :
				updateBookPriceById(sc);
				break;
			case 4 :
				deleteBookById(sc);
				break;
			case 0 :
				System.out.println("Thank For Using Our Application");
				break;
			default :
				System.out.println("Invalid Choice ");
			
			}
			
		}while(choice != 0);
		
		sc.close();
		
	}
	
}
