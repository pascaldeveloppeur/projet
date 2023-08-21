package com.moriset.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.moriset.user.model.User;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("properties")
public class UserControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	@Sql("/test.sql")
	public void getUserByIdTest() {
		
		ResponseEntity<User> response = testRestTemplate.getForEntity("/user/100", User.class);
		assertEquals(100, response.getBody().getId());
		assertEquals("Pascal", response.getBody().getName());
		assertEquals("Pascal", response.getBody().getEmail());
		assertEquals("Male", response.getBody().getGender());
		assertEquals("8524781", response.getBody().getPhone());
		
		
	}

}
