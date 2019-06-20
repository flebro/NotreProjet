package com.notreprojet.back.command;

import com.notreprojet.back.parsing.Instruction;
import com.notreprojet.back.parsing.Operators;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CommandFactoryTest {

	CommandFactory commandFactory;

	@Before
	public void init() {
		commandFactory = new CommandFactory(null);
	}

	@Test
	public void create_add() {
		Assertions.assertEquals(AddCommand.class, commandFactory.create(new Instruction(Operators.PLUS, 5)).getClass());
	}

	@Test
	public void create_sub() {
		Assertions.assertEquals(SubCommand.class, commandFactory.create(new Instruction(Operators.MINUS, 5)).getClass());
	}

	@Test
	public void create_multiply() {
		Assertions.assertEquals(MultiplyCommand.class, commandFactory.create(new Instruction(Operators.TIMES, 5)).getClass());
	}

	@Test
	public void create_divide() {
		Assertions.assertEquals(DivideCommand.class, commandFactory.create(new Instruction(Operators.DIVIDE, 5)).getClass());
	}

}