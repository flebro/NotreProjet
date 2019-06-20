package com.notreprojet.back.calculus;

import com.notreprojet.back.calculus.exception.CalculusException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link CalculatorImp}.
 */
public class CalculatorImpTest {

	CalculatorImp calculator;

	@Before
	public void init() {
		calculator = new CalculatorImp();
	}

	@Test
	public void add() {
		Assert.assertEquals(5F, calculator.add(2, 3), 0);
	}
	
	@Test
	public void sub() {
		Assert.assertEquals(3F, calculator.sub(6, 3), 0);
	}

	@Test
	public void divide() throws CalculusException {
		Assert.assertEquals(2.5F, calculator.divide(5, 2), 0);
	}

	@Test
	public void divide_by_zero() {
		try {
			calculator.divide(5, 0);
			Assert.fail();
		} catch (CalculusException e) {
			Assert.assertEquals(CalculusException.class, e.getClass());
		}
	}
	
	@Test
	public void multiply() {
		Assert.assertEquals(56F, calculator.multiply(7, 8), 0);
	}

}
