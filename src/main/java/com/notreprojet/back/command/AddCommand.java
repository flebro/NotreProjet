package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

/**
 * Command representing a sum instruction.
 */
public class AddCommand extends AbstractCalculationFunctionCommand {

	public AddCommand(Calculator calculator, float other) {
		super(calculator, other);
	}

	@Override
	public float execute(float number) {
		return getCalculator().add(number, getOther());
	}
}
