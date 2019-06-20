package com.notreprojet.back.parsing;

/**
 * Represents a recognized token.
 * @param <T>
 */
public class Token<T> {

	private T value;

	public T getValue() {
		return value;
	}

	public Token(T value) {
		this.value = value;
	}

	public Class getValueClass() {
		return value != null ? value.getClass() : null;
	}

}
