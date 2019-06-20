package com.notreprojet.back.command;

import com.notreprojet.back.calculus.Calculator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SinCommandTest {

	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.sin(60)).thenReturn(-0.3048106F);
		Assertions.assertEquals(-0.30481061339378357, new SinCommand(calculator, 60).execute(0));
	}
}