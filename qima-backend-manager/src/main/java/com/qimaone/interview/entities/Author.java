package com.qimaone.interview.entities;

import lombok.Data;

@Data
public class Author {

	private Long id;
    private String firstname;
    
	public Author() {
	}
	
    public Author(Long id, String firstname) {
		this.id = id;
		this.firstname = firstname;
	}
}
