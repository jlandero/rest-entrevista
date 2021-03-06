package cl.ionix.rest;

import java.security.GeneralSecurityException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ionix.rest.error.CustomEncryptException;
import cl.ionix.rest.service.RestService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test-key.properties",
properties = "report-subscriber=tester@example.com")
public class UserServiceKeyTest {
	
	@Autowired
    RestService userService;
 
    
    
	@Test(expected=CustomEncryptException.class)
    public void testUserService_Call_Api_NO_OK() throws GeneralSecurityException {    	    	
		userService.callExternalApi("1-9");
    }
}
