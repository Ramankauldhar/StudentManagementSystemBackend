package com.example.studentManagementSystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionHandling extends RuntimeException {

    private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundExceptionHandling(String message) {
		super(message);
	}
}
