package com.notreprojet.back.command;
import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Operators;

/**
 * Command representing a substraction instruction.
 */
public class SubCommand extends AbstractCalculationFunctionCommand {

	public SubCommand(Calculator calculator, float other) {
		super(calculator, Operators.MINUS, other);
	}

	@Override
	public float execute(float number) {
		return getCalculator().sub(number, getMember());
	}
}
