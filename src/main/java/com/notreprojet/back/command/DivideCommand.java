package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.exception.CalculusException;
import com.notreprojet.back.parsing.Operators;

/**
 * Command representing a division instruction.
 */
public class DivideCommand extends AbstractCalculationFunctionCommand {

	public DivideCommand(Calculator calculator, float other) {
		super(calculator, Operators.DIVIDE, other);
	}

	@Override
	public float execute(float number) throws CalculusException {
		return getCalculator().divide(number, getMember());
	}
}
