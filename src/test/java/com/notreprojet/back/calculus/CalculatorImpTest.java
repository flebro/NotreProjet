package com.notreprojet.back.calculus;

import com.notreprojet.back.calculus.exception.CalculusException;
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

	@Test
	public void divide() throws CalculusException {
		Assertions.assertEquals(2.5, calculator.divide(5, 2));
	}

	@Test
	public void divide_by_zero() {
		Assertions.assertThrows(CalculusException.class, () -> calculator.divide(5, 0));
	}

}