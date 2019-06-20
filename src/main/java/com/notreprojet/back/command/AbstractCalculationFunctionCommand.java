package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

/**
 * Abstract implementation of CalculationCommand for an operation with two members.
 */
public abstract class AbstractCalculationFunctionCommand implements CalculationCommand {

	private Calculator calculator;

	/**
	 * Gets this command instance calculator.
	 * @return this command instance calculator
	 */
	protected Calculator getCalculator() {
		return calculator;
	}

	private float other;
	/**
	 * Gets this command instance member.
	 * @return this command instance member
	 */
	protected float getOther() {
		return other;
	}

	public AbstractCalculationFunctionCommand(Calculator calculator, float other) {
		this.calculator = calculator;
		this.other = other;
	}

}
