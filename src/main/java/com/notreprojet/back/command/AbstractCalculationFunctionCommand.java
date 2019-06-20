package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Operators;

/**
 * Abstract implementation of CalculationCommand for an operation with two members.
 */
public abstract class AbstractCalculationFunctionCommand implements CalculationCommand {

	private transient Calculator calculator;

	/**
	 * Gets this command instance calculator.
	 * @return this command instance calculator
	 */
	protected Calculator getCalculator() {
		return calculator;
	}

	private transient float other;
	/**
	 * Gets this command instance member.
	 * @return this command instance member
	 */
	@Override
	public float getMember() {
		return other;
	}

	private transient Operators operator;
	/**
	 * Gets this command operator.
	 * @return this command instance operator
	 */
	@Override
	public Operators getOperator() {
		return operator;
	}

	public AbstractCalculationFunctionCommand(Calculator calculator, Operators operator, float other) {
		this.operator = operator;
		this.calculator = calculator;
		this.other = other;
	}

}
