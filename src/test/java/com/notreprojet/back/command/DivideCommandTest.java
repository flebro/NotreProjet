package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.exception.CalculusException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class DivideCommandTest {

	@Test
	public void execute() throws CalculusException {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.divide(6, 2)).thenReturn(3f);
		Assertions.assertEquals(3, new DivideCommand(calculator, 2).execute(6));
	}
}