package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Operators;

/**
 * Command representing a cosine instruction.
 */
public class CosCommand extends AbstractCalculationFunctionCommand {

	public CosCommand(Calculator calculator, float other) {
		super(calculator, Operators.COS, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().cos(getMember());
	}

}
