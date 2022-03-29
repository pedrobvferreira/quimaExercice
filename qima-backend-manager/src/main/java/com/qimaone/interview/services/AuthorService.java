package com.qimaone.interview.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qimaone.interview.entities.Author;

@Service
public class AuthorService {

    private Map<Long, Author> authorMap = new HashMap<>();

    public AuthorService() {
        this.authorMap.put(1L, new Author());
    }
    public Optional<Author> get(long id) {
        return Optional.ofNullable(authorMap.get(id));
    }
    
    public Author saveAuthor(Author author) {
		return authorMap.put(author.getId(), author);
	}
    
	public boolean existingAuthor(Long id) {
		return authorMap.containsKey(id);
	}
	
}
