package cl.ionix.rest;

import java.security.GeneralSecurityException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ionix.rest.controller.SearchController;
import cl.ionix.rest.error.BadRequestException;
import cl.ionix.rest.service.RestService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchControllerTest {
	
	@Autowired
	private SearchController searchController;
	
	@Mock
	private RestService restService;
	
	
	@Test		
	public void SearchControllerTest_OK() throws GeneralSecurityException {			
		ResponseEntity<String> httpResponse = searchController.call("1-9");	
		Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.OK);		
	}	
	
	@Test(expected=BadRequestException.class)	
	public void SearchControllerTest_NO_OK() throws GeneralSecurityException {			
		searchController.call("1-A");				
	}	

}
