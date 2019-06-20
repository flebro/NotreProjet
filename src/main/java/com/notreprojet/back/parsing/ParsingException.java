package com.notreprojet.back.parsing;

/**
 * Represents an error due to a input not suited for parsing.
 */
public class ParsingException extends Exception {

	public ParsingException(String message) {
		super(message);
	}

}
