package com.notreprojet.back.front;

import com.notreprojet.back.calculus.exception.CalculusException;
import com.notreprojet.back.command.CalculationCommand;
import com.notreprojet.back.command.CommandFactory;
import com.notreprojet.back.command.Switch;
import com.notreprojet.back.parsing.Instruction;
import com.notreprojet.back.parsing.Methods;
import com.notreprojet.back.parsing.Operators;
import com.notreprojet.back.parsing.ParsedInput;
import com.notreprojet.back.parsing.Parser;
import com.notreprojet.back.parsing.ParsingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for {@link ConsoleUI}.
 */
public class ConsoleUITest {

	private ConsoleUI consoleUI;

	@Before
	public void init() {
		consoleUI = new ConsoleUI();
	}

	@Test
	public void handleMethod() throws CalculusException {
		Switch calculusSwitch = Mockito.mock(Switch.class);
		Assert.assertEquals(0, consoleUI.handleMethod(Methods.QUIT, calculusSwitch).size());
	}

	@Test
	public void handleInput_quit() throws CalculusException, ParsingException {
		String inputMethod = "quit";

		ParsedInput parsedInputQuit = Mockito.mock(ParsedInput.class);
		Mockito.when(parsedInputQuit.getMethods()).thenReturn(Methods.QUIT);

		Parser parser = Mockito.mock(Parser.class);
		Mockito.when(parser.parseTokensList(inputMethod)).thenReturn(parsedInputQuit);

		List<String> outputs = consoleUI.handleInput(inputMethod, parser, null, null);
		Assert.assertEquals(0, outputs.size());
	}

	@Test
	public void handleInput_calc() throws CalculusException, ParsingException {
		String inputCalc = "5 + 5";

		Instruction instruction = Mockito.mock(Instruction.class);
		List<Instruction> instructions = new ArrayList<>();
		instructions.add(instruction);

		CalculationCommand command = Mockito.mock(CalculationCommand.class);
		Mockito.when(command.getMember()).thenReturn(5F);
		Mockito.when(command.getOperator()).thenReturn(Operators.PLUS);
		List<CalculationCommand> calculationCommands = new ArrayList<>();
		calculationCommands.add(command);

		ParsedInput parsedInput = Mockito.mock(ParsedInput.class);
		Mockito.when(parsedInput.getInstructions()).thenReturn(instructions);

		CommandFactory commandFactory = Mockito.mock(CommandFactory.class);
		Mockito.when(commandFactory.createFromParsedInput(parsedInput)).thenReturn(calculationCommands);

		Parser parser = Mockito.mock(Parser.class);
		Mockito.when(parser.parseTokensList(inputCalc)).thenReturn(parsedInput);

		Switch calculusSwitch = Mockito.mock(Switch.class);
		Mockito.when(calculusSwitch.getState()).thenReturn(5F);

		List<String> outputs = consoleUI.handleInput(inputCalc, parser, calculusSwitch, commandFactory);
		Assert.assertEquals(1, outputs.size());
		Assert.assertEquals("+ 5 = 5", outputs.get(0));
	}

	@Test
	public void runAndOutputCalculation() throws CalculusException {
		Switch calculusSwitch = Mockito.mock(Switch.class);
		CalculationCommand calculationCommand = Mockito.mock(CalculationCommand.class);
		Mockito.when(calculationCommand.getMember()).thenReturn(1F);
		Mockito.when(calculationCommand.getOperator()).thenReturn(Operators.PLUS);
		Mockito.when(calculusSwitch.getState()).thenReturn(2F);
		List<CalculationCommand> calculationCommands = new ArrayList<>();
		calculationCommands.add(calculationCommand);
		List<String> outputs = consoleUI.runAndOutputCalculation(calculusSwitch, calculationCommands);
		Assert.assertFalse(outputs.isEmpty());
		Assert.assertEquals("+ 1 = 2", outputs.get(0));
	}

}
