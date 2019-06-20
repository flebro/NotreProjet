package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link SubCommand}.
 */
public class SubCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.sub(7, 8)).thenReturn(1F);
		Assert.assertEquals(1, new SubCommand(calculator, 8).execute(7), 0);
	}
}
