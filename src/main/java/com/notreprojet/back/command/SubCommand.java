package com.notreprojet.back.command;
import com.notreprojet.back.calculus.Calculator;

/**
 * Command representing a substraction instruction.
 */
public class SubCommand implements CalculationCommand {
	private transient Calculator calculator;
	private transient float other;

	public SubCommand(Calculator calculator, float other) {
		this.calculator = calculator;
		this.other = other;
	}

	@Override
	public float execute(float number) {
		return calculator.sub(number, other);
	}
}
