package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link SubCommand}.
 */
public class SinCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.sin(60)).thenReturn(-0.3048106F);
		Assert.assertEquals(-0.30481061339378357, new SinCommand(calculator, 60).execute(0), 0);
	}
}
