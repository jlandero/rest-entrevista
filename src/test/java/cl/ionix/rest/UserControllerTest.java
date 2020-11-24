package cl.ionix.rest;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ionix.rest.controller.UserController;
import cl.ionix.rest.error.BadRequestException;
import cl.ionix.rest.model.User;
import cl.ionix.rest.service.RestService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect" })
@Sql("/test-mysql.sql")
@AutoConfigureTestDatabase
public class UserControllerTest {
	
	@Mock
	private RestService restService;
	
	@Autowired
	private UserController userController;
	
	@Test		
	public void UserControllerTest_List_OK() {			
		ResponseEntity<List<User>> httpResponse = userController.list();	
		Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);		
	}	
	
	@Test		
	public void UserControllerTest_Email_NO_Content() {			
		ResponseEntity<List<User>> httpResponse = userController.email("j.landero@gmail.com");	
		Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.NO_CONTENT);		
	}

	@Test(expected=BadRequestException.class)
	public void UserControllerTest_Email_NOT_Valid() {			
		userController.email("j.landero@com");	
				
	}
		
	@Test
	public void UserControllerTest_Save_OK() {			
		User user = new User(20, "name", "username", "email@email.com", "+5699854785");
		ResponseEntity<User> httpResponse = userController.save(user);	
		Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);		
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void UserControllerTest_Save_NO_OK() {			
		User user = new User(20, "name", "username", "email@.com", "+5699854785");
		userController.save(user);			
	}
}
