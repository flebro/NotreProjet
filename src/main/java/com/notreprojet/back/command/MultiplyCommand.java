package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;

public class MultiplyCommand extends AbstractCalculationFunctionCommand {

	public MultiplyCommand(Calculator calculator, float other) {
		super(calculator, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().multiply(number, getOther());
	}

}