package com.qimaone.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import com.qimaone.interview.controllers.BookController;
import com.qimaone.interview.entities.Book;
import com.qimaone.interview.services.BookService;

@WebMvcTest(BookController.class)
public class BookControllerTest {
	
	public static String endpoint = "/api/v1/";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookService bookService;
	
	
	@Test
	public void whenKeyIsPresent_thenReturnsTrue() {
	    Map<String, String> map = Collections.singletonMap("Book1", "BookValue");
	    
	    assertTrue(map.containsKey("Book1"));
	    assertFalse(map.containsKey("Book2"));
	}
	
	@Test
	public void savePersonTest() throws Exception {
		var book = new Book();
		book.setId(2345L);
		book.setName("the name of the book");
		book.setDescription("a short description");
		book.setIdAuthor(123L);
        when(bookService.saveBook(any(Book.class))).thenReturn(book);
        
        mockMvc.perform(post(endpoint + "/savebook")
        	.content(new ObjectMapper().writeValueAsString(book))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.name").value("the name of the book"))
            .andExpect(jsonPath("$.description").value("a short description"))
            .andExpect(jsonPath("$.idAuthor").value(123L))
            .andDo(print())
            .andExpect(status().isCreated())
            .andReturn();
	}
}
