package com.notreprojet.back.calculus.exception;

/**
 * Represent a invalid operation exception.
 */
public class CalculusException extends Exception {

	/**
	 * Constructor with an error message.
	 * @param message error message
	 */
	public CalculusException(String message) {
		super(message);
	}

}
