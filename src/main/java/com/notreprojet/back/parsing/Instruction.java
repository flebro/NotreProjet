package com.notreprojet.back.parsing;

/**
 * Represents a parsed instruction from an input.
 */
public class Instruction {

	private transient Operators operator;
	private transient float number;

	public Operators getOperator() {
		return operator;
	}

	public float getNumber() {
		return number;
	}

	public Instruction(Operators operator, float number) {
		this.operator = operator;
		this.number = number;
	}
}
