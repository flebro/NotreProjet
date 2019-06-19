package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

public abstract class AbstractCalculationFunctionCommand implements CalculationCommand {

	private Calculator calculator;
	protected Calculator getCalculator() {
		return calculator;
	}

	private float other;
	protected float getOther() {
		return other;
	}

	public AbstractCalculationFunctionCommand(Calculator calculator, float other) {
		this.calculator = calculator;
		this.other = other;
	}

}
