package com.notreprojet.back.parsing;

public class Instruction {

	private Operators operator;
	private float number;

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
