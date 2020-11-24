package cl.ionix.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import cl.ionix.rest.model.User;
import cl.ionix.rest.service.impl.RestServiceImpl;

@WebMvcTest
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private RestServiceImpl userService;
		
	@Test
	public void testGetAll() throws Exception {
		List<User> users = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setName("name");
		user.setEmail("email");
		user.setPhone("phone");
		user.setUsername("username");
		
		users.add(user);
		Mockito.when(userService.allUsers()).thenReturn(users);
		mockMvc.perform(get("/user/listUsers")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].name", Matchers.equalTo("name")));
	}
	

}
