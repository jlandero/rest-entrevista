package cl.ionix.rest.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.ionix.rest.error.BadRequestException;
import cl.ionix.rest.error.CustomEncryptException;
import cl.ionix.rest.error.IternalServerErrorException;
import cl.ionix.rest.model.User;
import cl.ionix.rest.repository.UserRepository;
import cl.ionix.rest.service.RestService;
import cl.ionix.rest.util.Utility;

@Service
public class RestServiceImpl implements RestService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${external.service.url}")
	private String url;
	@Value("${external.service.key}")
	private String key;	
	@Value("${external.service.type}")
	private String type;

	@Override
	public List<User> allUsers() {
		return userRepository.findAll();
	}

	@Override
	public List<User> userByEmail(String email) {
		
		if (!Utility.validateEmail(email))
			throw new BadRequestException("email invalido");
		
		return userRepository.findByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		
		if (!Utility.validateEmail(user.getEmail()))
			throw new BadRequestException("email invalido");
		
		return userRepository.save(user);
	}

	@Override
	public String callExternalApi(String rut) throws GeneralSecurityException {
		
		if (!Utility.validaRut(rut))
			throw new BadRequestException("rut invalido");
						
		String rutEnc = null;
		String responseServices = null;
		String jsonObject = null;
		long timeStart, timeEnd, timeTotal;
		
		try {
		
			DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
	        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(type);
	        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
	        byte[] dataBytes = rut.getBytes(StandardCharsets.UTF_8);
	        Cipher cipher2 = Cipher.getInstance(type);
	        cipher2.init(Cipher.ENCRYPT_MODE, secretKey);
	        rutEnc = Base64.getEncoder().encodeToString(cipher2.doFinal(dataBytes));
		} catch (GeneralSecurityException e) {
			throw new CustomEncryptException("Fallo el metodo de encriptacion " + e.getMessage());
		}		
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	    	
	    	timeStart = System.currentTimeMillis();			
	    	responseServices = restTemplate.getForObject(url+rutEnc, String.class);
	    	timeEnd = System.currentTimeMillis();
	    	timeTotal =  ( timeEnd - timeStart );	    		    	

	    } catch (Exception e) {
			throw new IternalServerErrorException("Error Llamado api externa : "+ e.getMessage());
		}
	    
	    try {
	    	jsonObject = Utility.mapeoNuevoObjeto(responseServices, timeTotal);
	    }catch (Exception e) {
	    	throw new IternalServerErrorException("Error generando nuevo objeto : "+ e.getMessage());
	    }
	    
	    return jsonObject;
	}

}
