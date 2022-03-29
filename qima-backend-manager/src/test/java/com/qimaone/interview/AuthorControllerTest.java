package com.qimaone.interview;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qimaone.interview.controllers.AuthorController;
import com.qimaone.interview.entities.Author;
import com.qimaone.interview.services.AuthorService;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

	public static String endpoint = "/api/v1/";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AuthorService authorService;
	
	@Test
	public void saveAuthorTest() throws Exception {
		var author = new Author(123L, "Chaitanya");
		when(authorService.saveAuthor(any(Author.class))).thenReturn(author);

        mockMvc.perform(post(endpoint + "/saveauthor")
        	.content(new ObjectMapper().writeValueAsString(author))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.firstname").value("Chaitanya"))
            .andDo(print())
            .andExpect(status().isCreated())
            .andReturn();
	}
}
