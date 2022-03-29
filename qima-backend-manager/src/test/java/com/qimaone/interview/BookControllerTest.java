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
	    Map<String, String> map = Collections.singletonMap("BookName", "BookValue");
	    
	    assertTrue(map.containsKey("BookName"));
	    assertFalse(map.containsKey("OtherBook"));
	}
	
	@Test
	public void savePersonTest() throws Exception {
		var book = new Book();
		book.setId(1L);
		book.setName("Example");
		book.setDescription("Example Exercice");
        when(bookService.saveBook(any(Book.class))).thenReturn(book);
        
        mockMvc.perform(post(endpoint + "/savebook")
        	.content(new ObjectMapper().writeValueAsString(book))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.name").value("Example"))
            .andExpect(jsonPath("$.description").value("Example Exercice"))
            .andDo(print())
            .andExpect(status().isCreated())
            .andReturn();
	}
}
