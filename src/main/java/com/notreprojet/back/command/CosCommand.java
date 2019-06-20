package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

/**
 * Command representing a cosine instruction.
 */
public class CosCommand extends AbstractCalculationFunctionCommand {

	public CosCommand(Calculator calculator, float other) {
		super(calculator, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().cos(getOther());
	}

}
