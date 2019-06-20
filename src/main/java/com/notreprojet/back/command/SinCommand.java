package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Operators;

/**
 * Command representing a sine instruction.
 */
public class SinCommand extends AbstractCalculationFunctionCommand {

	public SinCommand(Calculator calculator, float other) {
		super(calculator, Operators.SIN, other);
	}
	
	@Override
	public float execute(float number) {
		return getCalculator().sin(getMember());
	}

}
