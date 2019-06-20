package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.exception.CalculusException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link DivideCommand}.
 */
public class DivideCommandTest {

	@Test
	public void execute() throws CalculusException {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.divide(6, 2)).thenReturn(3f);
		Assert.assertEquals(3, new DivideCommand(calculator, 2).execute(6), 0);
	}
}
