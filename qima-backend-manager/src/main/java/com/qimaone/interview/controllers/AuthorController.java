package com.qimaone.interview.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qimaone.interview.entities.Author;
import com.qimaone.interview.services.AuthorService;

@RestController
@RequestMapping("/api/v1/")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping("/saveauthor")
    private ResponseEntity<?> saveAuthor(@RequestBody Author author) {
    	var savedAuthor = authorService.saveAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthor);
    }
}
