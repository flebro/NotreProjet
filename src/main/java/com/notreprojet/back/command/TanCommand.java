package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

public class TanCommand extends AbstractCalculationFunctionCommand {

	public TanCommand(Calculator calculator, float other) {
		super(calculator, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().tan(getOther());
	}

}
