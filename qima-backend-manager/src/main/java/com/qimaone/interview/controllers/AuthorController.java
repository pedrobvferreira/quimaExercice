package com.qimaone.interview.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qimaone.interview.entities.Author;

@RestController
@RequestMapping("/api/v1/")
public class AuthorController {
	
	@PostMapping("/savebook")
    private ResponseEntity<?> saveBook(@RequestBody Author author) {
		return null;
//    	var user = personService.saveBook(author);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
