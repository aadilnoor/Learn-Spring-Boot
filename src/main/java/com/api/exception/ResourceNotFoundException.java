package com.api.exception;

import com.api.constants.ErrorMessages;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
