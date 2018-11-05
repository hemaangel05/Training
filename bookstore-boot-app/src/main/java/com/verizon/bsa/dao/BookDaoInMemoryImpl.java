package com.verizon.bsa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Repository;

import com.verizon.bsa.model.Book;

@Repository
public class BookDaoInMemoryImpl implements BookDao{
	
	Map<Integer,Book> books;
	
	public BookDaoInMemoryImpl() {
		books = new TreeMap<>();
		
		books.put(101, new Book(101,"The Hound Of Basekrvelli",522,"Novel","Hardcopy"));
		books.put(102, new Book(102,"The Tree And Three Chuldren",822,"Novel","Hardcopy"));
		books.put(103, new Book(103,"The Killer On Loose",122,"Novel","Hardcopy"));
	}

	@Override
	public Book addBook(Book book) {
		books.put(book.getBcode(), book);
		return book;
	}

	@Override
	public Book updateBook(Book book) {
		books.replace(book.getBcode(), book);
		return book;
	}

	@Override
	public Book getBookById(int bcode) {
		return books.get(bcode);
	}

	@Override
	public boolean deleteBookById(int bcode) {
		boolean isDeleted=false;
		if(books.containsKey(bcode)) {
			books.remove(bcode);
			isDeleted=true;
		}
		return isDeleted;
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<Book>(books.values());
	}

}
