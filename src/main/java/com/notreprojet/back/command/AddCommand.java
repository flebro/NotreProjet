package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Operators;

/**
 * Command representing a sum instruction.
 */
public class AddCommand extends AbstractCalculationFunctionCommand {

	public AddCommand(Calculator calculator, float other) {
		super(calculator, Operators.PLUS, other);
	}

	@Override
	public float execute(float number) {
		return getCalculator().add(number, getMember());
	}
}
