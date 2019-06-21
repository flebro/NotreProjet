package com.notreprojet.back.parsing;

/**
 * Represents an error due to a input not suited for parsing.
 */
public class ParsingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1706702346764588556L;

	public ParsingException(String message) {
		super(message);
	}

}
