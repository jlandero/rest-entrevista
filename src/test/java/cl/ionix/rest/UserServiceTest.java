package cl.ionix.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ionix.rest.model.User;
import cl.ionix.rest.service.RestService;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect" })
@Sql("/test-mysql.sql")
@AutoConfigureTestDatabase
public class UserServiceTest {
	
	@Autowired
    RestService userService;
 
    @Test
    public void testUserService_AllUsers() {
    	assertThat(userService.allUsers()).hasSize(6);
    }
    
    @Test
    public void testUserService_FindEmail_OK() {
    	assertThat(userService.userByEmail("bender@algo.com")).hasSize(1);
    }

    
    @Test
    public void testUserService_FindEmail_NO_OK() {
    	assertThat(userService.userByEmail("cosas@algo.com")).hasSize(0);
    }
    
    @Test
    public void testUserService_SaveUser_OK() {
    	User user = new User();
    	user.setId(7);
    	user.setEmail("algo@algo.com");
    	user.setName("algo");
    	user.setPhone("+56998958699");
    	user.setUsername("algo");    	
    	assertThat(userService.saveUser(user)).isNotNull();
    }
    
}
