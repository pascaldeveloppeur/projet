package com.moriset.user;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moriset.user.controller.UserController;
import com.moriset.user.model.User;
import com.moriset.user.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	/*	@Test 
		
	public void getUserById() throws Exception {
		Integer id = 1;
		User user = new User(id,"pascal","pascal@gmail.com","698100186","Male");
		
		
		
		
		
		when(userService.getUserById(id)).thenReturn(user);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}",id))
		.andDo(print())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id))
		.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(user.getName()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.email").value(user.getEmail()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.phone").value(user.getPhone()))
		.andExpect(MockMvcResultMatchers.jsonPath("$.gender").value(user.getGender()))
		
		.andExpect(status().isOk());
	
	}*/
	
	@Test
	public void saveUserTest() throws Exception {
		
		User user = new User();
		user.setId(1);
		user.setName("alex");
		user.setEmail("alex@gmail.com");
		user.setPhone("677589621");
		user.setGender("Femelle");
		
		when(userService.saveUser(user)).thenReturn(user);
		
		 mockMvc.perform(MockMvcRequestBuilders.post("/user")
				.content(new ObjectMapper().writeValueAsString(user))
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isCreated())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("alex"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("alex@gmail.com"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.phone").value("677589621"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Femelle"))
		        .andExpect(status().isOk())
				;
				
	}
}
