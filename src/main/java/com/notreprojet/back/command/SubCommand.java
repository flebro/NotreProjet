package com.notreprojet.back.command;
import com.notreprojet.back.calculus.Calculator;

/**
 * Command representing a substraction instruction.
 */
public class SubCommand implements CalculationCommand {
	private Calculator calculator;
	private float other;

	public SubCommand(Calculator calculator, float other) {
		this.calculator = calculator;
		this.other = other;
	}

	@Override
	public float execute(float number) {
		return calculator.sub(number, other);
	}
}
