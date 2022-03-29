package com.qimaone.interview.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.qimaone.interview.entities.Book;

@Service
public class BookService {

	private Map<String, Book> bookMap = new HashMap<>();
	
	public Book saveBook(Book book) {
		return bookMap.put(book.getName(), book);
	}
	
	public boolean existingBook(String name) {
		return bookMap.containsKey(name);
	}

}
