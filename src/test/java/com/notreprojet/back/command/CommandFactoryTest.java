package com.notreprojet.back.command;

import com.notreprojet.back.parsing.Instruction;
import com.notreprojet.back.parsing.Operators;
import com.notreprojet.back.parsing.ParsedInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for {@link CommandFactory}.
 */
public class CommandFactoryTest {

	CommandFactory commandFactory;

	@Before
	public void init() {
		commandFactory = new CommandFactory(null);
	}

	@Test
	public void create_add() {
		Assert.assertEquals(AddCommand.class,
				commandFactory.create(new Instruction(Operators.PLUS, 5)).getClass());
	}

	@Test
	public void create_sub() {
		Assert.assertEquals(SubCommand.class,
				commandFactory.create(new Instruction(Operators.MINUS, 5)).getClass());
	}

	@Test
	public void create_multiply() {
		Assert.assertEquals(MultiplyCommand.class,
				commandFactory.create(new Instruction(Operators.TIMES, 5)).getClass());
	}

	@Test
	public void create_divide() {
		Assert.assertEquals(DivideCommand.class,
				commandFactory.create(new Instruction(Operators.DIVIDE, 5)).getClass());
	}

	@Test
	public void createFromParsedInput() {
		ParsedInput parsedInput = Mockito.mock(ParsedInput.class);
		Instruction instruction = new Instruction(Operators.PLUS, 5);
		List<Instruction> instructions = new ArrayList<>();
		instructions.add(instruction);
		Mockito.when(parsedInput.getInstructions()).thenReturn(instructions);
		List<CalculationCommand> calculationCommands =
				commandFactory.createFromParsedInput(parsedInput);
		Assert.assertEquals(AddCommand.class, calculationCommands.get(0).getClass());
	}

}
