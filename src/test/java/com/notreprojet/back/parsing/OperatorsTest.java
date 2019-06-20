package com.notreprojet.back.parsing;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;

/**
 * Test class for {@link Operators}.
 */
public class OperatorsTest {

	@Test
	public void fromToken_plus() {
		Assertions.assertEquals(Operators.PLUS, Operators.fromToken("+").get());
	}

	@Test
	public void fromToken_minus() {
		Assertions.assertEquals(Operators.MINUS, Operators.fromToken("-").get());
	}

	@Test
	public void fromToken_times() {
		Assertions.assertEquals(Operators.TIMES, Operators.fromToken("*").get());
	}

	@Test
	public void fromToken_divide() {
		Assertions.assertEquals(Operators.DIVIDE, Operators.fromToken("/").get());
	}

	@Test
	public void fromToken_none() {
		Assertions.assertThrows(NoSuchElementException.class, () -> Operators.fromToken("").get());
	}
}
