package xyz.hskr.cars.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You have entered a parameter in that does not exist")
public class BodyParamaterException extends DataIntegrityViolationException{

	public BodyParamaterException(String msg) {
		super(msg);	
		// TODO Auto-generated constructor stub
	}
	

	
}
