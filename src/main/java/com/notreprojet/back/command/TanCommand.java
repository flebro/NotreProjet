package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Operators;

/**
 * Command representing a tangent instruction.
 */
public class TanCommand extends AbstractCalculationFunctionCommand {

	public TanCommand(Calculator calculator, float other) {
		super(calculator, Operators.TAN, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().tan(getMember());
	}

}
