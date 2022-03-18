package xyz.hskr.cars.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Input")
public class NoSuchElementFoundException extends NoSuchElementException{
	public NoSuchElementFoundException(String msg) {
		super(msg);
	}
}
