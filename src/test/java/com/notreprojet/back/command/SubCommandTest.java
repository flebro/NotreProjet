package com.notreprojet.back.command;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import com.notreprojet.back.calculus.Calculator;
import static org.junit.Assert.*;

public class SubCommandTest {
	@Test
	public void execute() {
		Calculator calculator = Mockito.mock(Calculator.class);
		Mockito.when(calculator.sub(6, 2)).thenReturn(4f);
		Assertions.assertEquals(4, new SubCommand(calculator, 2).execute(6));
	}
}
