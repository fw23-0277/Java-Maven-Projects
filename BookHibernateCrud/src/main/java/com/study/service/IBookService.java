package com.study.service;

import java.math.BigDecimal;

import com.study.entity.Book;
import com.study.exception.NoRecordFoundException;
import com.study.exception.SomehingWentWrongException;

public interface IBookService {
	public void addBook(Book book) throws SomehingWentWrongException;
	public Book getBookById(int id) throws SomehingWentWrongException , NoRecordFoundException;
	public void updateBookPrice(int id , BigDecimal price) throws SomehingWentWrongException , NoRecordFoundException;
	public void deleteBookById(int id) throws SomehingWentWrongException , NoRecordFoundException;
}
