package cl.ionix.rest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cl.ionix.rest.util.Utility;

@SpringBootTest
public class UtilityTest {	
	
	@Test
    public void tesUtility_Rut_OK() {	
		String rut = "12312312-3";
		assertThat(Utility.validaRut(rut)).isTrue();
    }
	
	@Test
    public void tesUtility_Rut_NO_OK() {	
		String rut = "12312312-A";
		assertThat(Utility.validaRut(rut)).isFalse();
    }
	
	@Test
    public void tesUtility_Email_OK() {	
		String email = "algo@quees.com";
		assertThat(Utility.validateEmail(email)).isTrue();
    }
	
	@Test
    public void tesUtility_Email_NO_OK() {	
		String email = "algo@quees_com";
		assertThat(Utility.validateEmail(email)).isFalse();
    }
	
	@Test
    public void tesUtility_MapeoNuevoObjeto_OK() {	
		String responseServices = "{\"responseCode\":0,\"description\":\"OK\",\"result\":{\"items\":[{\"name\":\"John\",\"detail\":{\"email\":\"jdoe@gmail.com\",\"phone_number\":\"+130256897875\"}},{\"name\":\"Anna\",\"detail\":{\"email\":\"asmith@gmail.com\",\"phone_number\":\"+5689874521\"}},{\"name\":\"Peter\",\"detail\":{\"email\":\"pjones@gmail.com\",\"phone_number\":\"+668978542365\"}}]}}";
		assertThat(Utility.mapeoNuevoObjeto(responseServices, 150)).isNotBlank();
    }
	
	@Test(expected=NullPointerException.class)
    public void tesUtility_MapeoNuevoObjeto_NO_OK() {	
		String responseServices = "{\"responseCode\":0,\"description\":\"OK\",\"result\":{\"items2\":[{\"name\":\"John\",\"detail\":{\"email\":\"jdoe@gmail.com\",\"phone_number\":\"+130256897875\"}},{\"name\":\"Anna\",\"detail\":{\"email\":\"asmith@gmail.com\",\"phone_number\":\"+5689874521\"}},{\"name\":\"Peter\",\"detail\":{\"email\":\"pjones@gmail.com\",\"phone_number\":\"+668978542365\"}}]}}";
		Utility.mapeoNuevoObjeto(responseServices, 0);
    }
}
