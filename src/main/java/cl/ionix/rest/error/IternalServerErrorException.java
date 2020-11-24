package cl.ionix.rest.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class IternalServerErrorException extends RuntimeException {
	private final Logger logger = LoggerFactory.getLogger(IternalServerErrorException.class);
	
	public IternalServerErrorException(String message){
        super(message);
        logger.error(message);
    }
}
