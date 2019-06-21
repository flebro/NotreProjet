package com.notreprojet.back.parsing;

import java.util.Arrays;
import java.util.Optional;

/**
 * This enum repertories all input methods available.
 */
public enum Methods {

	QUIT ("quit"),
	HISTORY ("history"),
	SUM_HISTORY ("sumhistory");

	private String token;

	/**
	 * Get the input token corresponding to a method.
	 * @return
	 */
	public String getToken() {
		return token;
	}

	Methods(String token) {
		this.token = token;
	}

	/**
	 * Retrieve a Methods instance from a token.
	 * @param token
	 * @return
	 */
	public static Optional<Methods> fromToken(String token) {
		return Arrays.stream(values()).filter(methods -> methods.token.equals(token)).findAny();
	}

}
