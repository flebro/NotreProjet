package com.notreprojet.back.calculus;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class CalculatorImpTest {

	CalculatorImp calculator;

	@Before
	public void init() {
		calculator = new CalculatorImp();
	}

	@Test
	public void add() {
		Assertions.assertEquals(5, calculator.add(2, 3));
	}

}