package com.notreprojet.back.parsing;

import java.util.Arrays;
import java.util.Optional;

/**
 * This enumeration lists the operations known by the application.
 */
public enum Operators {

	PLUS ("+"),
	MINUS ("-"),
	TIMES ("*"),
	DIVIDE ("/"),
	SIN ("sin"),
	COS ("cos"),
	TAN ("tan");

	private String token;

	public String getToken() {
		return token;
	}

	Operators(String token) {
		this.token = token;
	}

	public static Optional<Operators> fromToken(String token) {
		return Arrays.stream(values()).filter(operators -> operators.token.equals(token)).findAny();
	}

}
