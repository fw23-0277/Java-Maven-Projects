package com.study.dao;

import java.math.BigDecimal;

import com.study.entity.Book;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomehingWentWrongException;
import com.study.utility.EMUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transaction;
import jakarta.transaction.TransactionManager;

public class BookDAOImpl implements IBookDAO {

	public void addBook(Book book) throws SomehingWentWrongException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction et = null;

		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(book);
			et.commit();
		} catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			throw new SomehingWentWrongException("Opps...! Unable to add book.");
		}

	}

	public Book getBookById(int id) throws SomehingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		Book book = null;
		try {
			em = EMUtils.getEntityManager();
			book = em.find(Book.class, id);
			if (book == null) {
				throw new NoRecordFoundException("Opps...! No Book Found Given Id.");
			}
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			throw new SomehingWentWrongException("Oops...! Unable to found book.");
		}finally {
			em.close();
		}
		return book;
	}

	public void updateBookPrice(int id, BigDecimal price) throws SomehingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Book book = getBookById(id);
	
	
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			book.setPrice(price);
			em.merge(book);
			
			et.commit();
		} catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			throw new SomehingWentWrongException("Oops...! Unable to found book.");
		}finally {
			em.close();
		}

	}

	public void deleteBookById(int id) throws SomehingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		Book book = getBookById(id);
		
		EntityManager em = null;
		EntityTransaction et = null;
		
		try {
			em = EMUtils.getEntityManager();
			et = em.getTransaction();
			et.begin();
			book = em.merge(book);
			em.remove(book);
			et.commit();
		} catch (PersistenceException e) {
			// TODO: handle exception
			et.rollback();
			System.out.println(e.getMessage());
		}finally {
			em.close();
		}
	}

}
