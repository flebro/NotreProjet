package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

public class AddCommand implements CalculationCommand {

	private Calculator calculator;
	private float other;

	public AddCommand(Calculator calculator, float other) {
		this.calculator = calculator;
		this.other = other;
	}

	@Override
	public float execute(float number) {
		return calculator.add(number, other);
	}
}
