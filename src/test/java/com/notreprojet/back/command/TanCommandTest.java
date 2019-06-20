package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class TanCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.tan(60)).thenReturn(0.32004037F);
		Assertions.assertEquals(0.32004037499427795, new TanCommand(calculator, 60).execute(0));
	}
}