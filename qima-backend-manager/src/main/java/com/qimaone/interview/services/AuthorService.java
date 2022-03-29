package com.qimaone.interview.services;

import com.qimaone.interview.entities.Author;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthorService {

    private Map<Long, Author> authorMap = new HashMap<>();

    public AuthorService() {
        this.authorMap.put(1L, new Author());
    }
    public Optional<Author> get(long id) {
        return Optional.ofNullable(authorMap.get(id));
    }
    
    
}
