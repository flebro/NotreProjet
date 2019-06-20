package com.notreprojet.back.parsing;

import com.notreprojet.back.parsing.Operators;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;

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

	@Test
	public void fromToken_none() {
		Assertions.assertThrows(NoSuchElementException.class, () -> Operators.fromToken("").get());
	}
}