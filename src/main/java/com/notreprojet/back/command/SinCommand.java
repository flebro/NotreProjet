package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

public class SinCommand extends AbstractCalculationFunctionCommand {

	public SinCommand(Calculator calculator, float other) {
		super(calculator, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().sin(getOther());
	}

}
