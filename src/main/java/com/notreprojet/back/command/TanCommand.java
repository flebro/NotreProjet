package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

/**
 * Command representing a tangent instruction.
 */
public class TanCommand extends AbstractCalculationFunctionCommand {

	public TanCommand(Calculator calculator, float other) {
		super(calculator, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().tan(getOther());
	}

}
