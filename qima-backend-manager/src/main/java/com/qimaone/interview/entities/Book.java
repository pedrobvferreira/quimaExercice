package com.qimaone.interview.entities;

import lombok.Data;

@Data
public class Book {

	private Long id;
    private String name;
    private String description;
    
    private Long idAuthor;
    
    public Book() {
	}
	
    public Book(Long id, String name,  String description, Long idAuthor) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.idAuthor = idAuthor;
	}
}
