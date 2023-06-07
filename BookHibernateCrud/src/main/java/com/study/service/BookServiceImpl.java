package com.study.service;

import java.math.BigDecimal;

import com.study.dao.BookDAOImpl;
import com.study.dao.IBookDAO;
import com.study.entity.Book;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomehingWentWrongException;

public class BookServiceImpl implements IBookService {

	public void addBook(Book book) throws SomehingWentWrongException {
		// TODO Auto-generated method stub
		IBookDAO bookDAO = new BookDAOImpl();
		bookDAO.addBook(book);

	}

	public Book getBookById(int id) throws SomehingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IBookDAO bookDAO = new BookDAOImpl();
		return bookDAO.getBookById(id);
	}

	public void updateBookPrice(int id, BigDecimal price) throws SomehingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IBookDAO bookDAO = new BookDAOImpl();
		bookDAO.updateBookPrice(id, price);

	}

	public void deleteBookById(int id) throws SomehingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		IBookDAO bookDAO = new BookDAOImpl();
		bookDAO.deleteBookById(id);

	}

}
