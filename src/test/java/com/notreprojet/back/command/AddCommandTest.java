package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.parsing.Operators;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Test class for @{link AddCommand}.
 */
public class AddCommandTest {

	@Test
	public void getCalculator() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Assert.assertEquals(calculator, new AddCommand(calculator, 6).getCalculator());
	}

	@Test
	public void getMember() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Assert.assertEquals(6F, new AddCommand(calculator, 6).getMember(), 0);
	}

	@Test
	public void getOperator() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Assert.assertEquals(Operators.PLUS, new AddCommand(calculator, 6).getOperator());
	}

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.add(5, 6)).thenReturn(11f);
		Assert.assertEquals(11, new AddCommand(calculator, 6).execute(5), 0);
	}
}
