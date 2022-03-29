package com.qimaone.interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qimaone.interview.entities.Book;
import com.qimaone.interview.services.BookService;

@RestController
@RequestMapping("/api/v1/")
public class BookController {
	
	@Autowired
	private BookService bookService;
//	@Autowired
//	private AuthorService authorService;
	
	@PostMapping("/savebook")
	private ResponseEntity<?> saveBook(@RequestBody Book book) {
		var existingBook = bookService.existingBook(book.getName());
		if (existingBook) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
//			var existingAuthor = authorService.existingAuthor(book.getIdAuthor());
//			if (!existingAuthor.isPresent()) {
//				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			} else {
//				var savedBook = bookService.saveBook(book);
//				return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
//			}
			var savedBook = bookService.saveBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
		}
	}
}
