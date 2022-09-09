package com.multiclientweb.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleOrderNotFoundException(OrderNotFoundException ex) {
        ErrorMessage error = new ErrorMessage();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	
	//this exception is for to handle validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String messageString=error.getDefaultMessage();
			resp.put(fieldName, messageString);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);		
	}
}
