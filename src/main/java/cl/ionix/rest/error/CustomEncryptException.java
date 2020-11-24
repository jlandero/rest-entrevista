package cl.ionix.rest.error;

import java.security.GeneralSecurityException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class CustomEncryptException extends GeneralSecurityException {
	private final Logger logger = LoggerFactory.getLogger(CustomEncryptException.class);
	
	public CustomEncryptException(String message){
        super(message);
        logger.error(message);
    }
}

