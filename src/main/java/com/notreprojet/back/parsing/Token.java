package com.notreprojet.back.parsing;

/**
 * Represents a recognized token.
 * @param <T>
 */
public class Token<T> {

	private final transient T value;

	public T getValue() {
		return value;
	}

	public Token(T value) {
		this.value = value;
	}

	public Class getValueClass() {
		return value == null ? null : value.getClass();
	}

}
