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
	public void sub() {
		Assertions.assertEquals(3, calculator.sub(6, 3));
	}

	@Test
	public void divide() throws CalculusException {
		Assertions.assertEquals(2.5, calculator.divide(5, 2));
	}

	@Test
	public void divide_by_zero() {
		Assertions.assertThrows(CalculusException.class, () -> calculator.divide(5, 0));
	}
	
	@Test
	public void multiply() {
		Assertions.assertEquals(56, calculator.multiply(7, 8));
	}
	
	@Test
	public void sin() {
		Assertions.assertEquals(-0.30481061339378357, calculator.sin(60));
	}
	
	@Test
	public void cos() {
		Assertions.assertEquals(-0.9524129629135132, calculator.cos(60));
	}

	@Test
	public void tan() {
		Assertions.assertEquals(0.32004037499427795, calculator.tan(60));
	}
}