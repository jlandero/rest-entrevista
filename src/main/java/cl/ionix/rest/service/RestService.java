package cl.ionix.rest.service;

import java.security.GeneralSecurityException;
import java.util.List;

import cl.ionix.rest.model.User;

public interface RestService {
	
	public List<User> allUsers();
	public List<User> userByEmail(String email);
	public User saveUser(User user);
	public String callExternalApi(String rut) throws GeneralSecurityException;

}
