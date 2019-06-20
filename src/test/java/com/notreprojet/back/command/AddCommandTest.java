package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

/**
 * Test class for @{link AddCommand}.
 */
public class AddCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.add(5, 6)).thenReturn(11f);
		Assertions.assertEquals(11, new AddCommand(calculator, 6).execute(5));
	}
}
