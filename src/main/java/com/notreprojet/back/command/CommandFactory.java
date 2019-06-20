package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Instruction;

/**
 * This class is responsible of building commands from instructions.
 */
public class CommandFactory {

	Calculator calculator;

	public CommandFactory(Calculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Create a command from an instruction.
	 * @param instruction instruction to build a command from
	 * @return the builded command
	 */
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
			case SIN:
				return new SinCommand(calculator, instruction.getNumber());
			case COS:
				return new CosCommand(calculator, instruction.getNumber());
			case TAN:
				return new TanCommand(calculator, instruction.getNumber());
			default: return null;
		}
	}

}
