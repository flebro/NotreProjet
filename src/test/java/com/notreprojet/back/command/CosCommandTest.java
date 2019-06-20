package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CosCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.cos(60)).thenReturn(-0.95241296F);
		Assertions.assertEquals(-0.9524129629135132, new CosCommand(calculator, 60).execute(0));
	}
}