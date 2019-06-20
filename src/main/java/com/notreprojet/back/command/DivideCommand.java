package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.exception.CalculusException;

/**
 * Command representing a division instruction.
 */
public class DivideCommand extends AbstractCalculationFunctionCommand {

	public DivideCommand(Calculator calculator, float other) {
		super(calculator, other);
	}

	@Override
	public float execute(float number) throws CalculusException {
		return getCalculator().divide(number, getOther());
	}
}
