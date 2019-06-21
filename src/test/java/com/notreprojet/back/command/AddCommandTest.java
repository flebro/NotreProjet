package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for @{link AddCommand}.
 */
public class AddCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.add(5, 6)).thenReturn(11f);
		Assert.assertEquals(11, new AddCommand(calculator, 6).execute(5), 0);
	}
}
