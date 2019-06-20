package com.notreprojet.back.parsing;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link Operators}.
 */
public class OperatorsTest {

	@Test
	public void fromToken_plus() {
		Assert.assertEquals(Operators.PLUS, Operators.fromToken("+").get());
	}

	@Test
	public void fromToken_minus() {
		Assert.assertEquals(Operators.MINUS, Operators.fromToken("-").get());
	}

	@Test
	public void fromToken_times() {
		Assert.assertEquals(Operators.TIMES, Operators.fromToken("*").get());
	}

	@Test
	public void fromToken_divide() {
		Assert.assertEquals(Operators.DIVIDE, Operators.fromToken("/").get());
	}
	
	@Test
	public void fromToken_sin() {
		Assertions.assertEquals(Operators.SIN, Operators.fromToken("sin").get());
	}
	
	@Test
	public void fromToken_cos() {
		Assertions.assertEquals(Operators.COS, Operators.fromToken("cos").get());
	}
	
	@Test
	public void fromToken_tan() {
		Assertions.assertEquals(Operators.TAN, Operators.fromToken("tan").get());
	}

}
