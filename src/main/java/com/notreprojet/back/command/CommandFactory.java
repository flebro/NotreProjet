package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Instruction;

public class CommandFactory {

	Calculator calculator;

	public CommandFactory(Calculator calculator) {
		this.calculator = calculator;
	}

	public CalculationCommand create(Instruction instruction) {
		switch (instruction.getOperator()) {
			case PLUS:
				return new AddCommand(calculator, instruction.getNumber());
			case MINUS:
				return new SubCommand(calculator, instruction.getNumber());
			case TIMES:
				return new MultiplyCommand(calculator, instruction.getNumber());
			case DIVIDE:
				return new DivideCommand(calculator, instruction.getNumber());
			default: return null;
		}
	}

}
