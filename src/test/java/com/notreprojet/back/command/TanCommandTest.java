package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for {@link SubCommand}.
 */
public class TanCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.tan(60)).thenReturn(0.32004037F);
		Assert.assertEquals(0.32004037499427795, new TanCommand(calculator, 60).execute(0), 0);
	}
}
