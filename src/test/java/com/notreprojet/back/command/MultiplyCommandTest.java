package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

/**
 * Test class for {@link MultiplyCommand}.
 */
public class MultiplyCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.multiply(7, 8)).thenReturn(56f);
		Assertions.assertEquals(56, new MultiplyCommand(calculator, 8).execute(7));
	}
}
