package com.api.exception;

import com.api.constants.ErrorMessages;

public class InvalidInputException extends RuntimeException {

	public InvalidInputException() {
		super(ErrorMessages.INVALID_INPUT);
	}
}
