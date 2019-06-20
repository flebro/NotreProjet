package com.notreprojet.back.front;

import com.notreprojet.back.calculus.exception.CalculusException;
import com.notreprojet.back.command.CalculationCommand;
import com.notreprojet.back.command.Switch;
import com.notreprojet.back.parsing.Methods;
import com.notreprojet.back.parsing.Operators;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for {@link ConsoleUI}.
 */
public class ConsoleUITest {

	@Test
	public void handleMethod() throws CalculusException {
		Switch calculusSwitch = Mockito.mock(Switch.class);
		ConsoleUI consoleUI = new ConsoleUI();
		Assert.assertEquals(true, consoleUI.handleMethod(Methods.QUIT, calculusSwitch));
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
		List<String> outputs = new ConsoleUI().runAndOutputCalculation(calculusSwitch, calculationCommands);
		Assert.assertFalse(outputs.isEmpty());
		Assert.assertEquals("+ 1 = 2", outputs.get(0));
	}

}
