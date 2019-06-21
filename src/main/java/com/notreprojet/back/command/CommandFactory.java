package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Instruction;
import com.notreprojet.back.parsing.ParsedInput;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible of building commands from instructions.
 */
public class CommandFactory {

	private final transient Calculator calculator;

	public CommandFactory(Calculator calculator) {
		this.calculator = calculator;
	}

	/**
	 * Create a command from an instruction.
	 * @param instruction instruction to build a command from
	 * @return the builded command
	 */
	public CalculationCommand create(Instruction instruction) {
		if (instruction.getOperator() != null) {
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
			}
		}
		return null;
	}

	/**
	 * Creates a list of commands from a {@link ParsedInput}.
	 * @param parsedInput parsedInput to create commands from
	 * @return commands created
	 */
	public List<CalculationCommand> createFromParsedInput(ParsedInput parsedInput) {
		return 	parsedInput.getInstructions().stream()
				.map(this::create).collect(Collectors.toList());
	}

}
