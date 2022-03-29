package com.qimaone.interview.entities;

import lombok.Data;

@Data
public class Book {

	private Long id;
    private String name;
    private String description;
    
    private Long idAuthor;
}
