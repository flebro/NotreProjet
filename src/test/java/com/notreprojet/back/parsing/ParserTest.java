package com.notreprojet.back.parsing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for {@link Parser}.
 */
public class ParserTest {

	private static final String TOKEN_LIST = " 5 - 3 ";
	private Parser parser;

	@Before
	public void init() {
		parser = new Parser();
	}

	@Test
	public void parseTokensList_ok() throws ParsingException {
		ParsedInput parsedInput = parser.parseTokensList(TOKEN_LIST);
		assertEquals(Operators.PLUS, parsedInput.getInstructions().get(0).getOperator());
		assertEquals(5, parsedInput.getInstructions().get(0).getNumber(), 0);
		assertEquals(Operators.MINUS, parsedInput.getInstructions().get(1).getOperator());
		assertEquals(3, parsedInput.getInstructions().get(1).getNumber(), 0);
		assertEquals(true, parsedInput.isReset());
	}

	@Test
	public void parseTokensList_errors() throws ParsingException {
		try {
			parser.parseTokensList("5 5");
			parser.parseTokensList("");
			parser.parseTokensList("5 +");
			parser.parseTokensList("+ -");
			parser.parseTokensList("exit 5");
			Assert.fail();
		} catch (ParsingException e) {
			assertEquals(ParsingException.class, e.getClass());
		}
	}

	@Test
	public void parseToken_operator() throws ParsingException {
		Token token = parser.parseToken(Operators.PLUS.getToken());
		assertEquals(Operators.class, token.getValueClass());
		assertEquals(Operators.PLUS, token.getValue());
	}

	@Test
	public void parseToken_numeric() throws ParsingException {
		Token token = parser.parseToken("5");
		assertEquals(Float.class, token.getValueClass());
		assertEquals(5F, token.getValue());
	}

	@Test
	public void parseToken_exception() {
		try {
			parser.parseToken("####");
			Assert.fail();
		} catch (ParsingException e) {
			assertEquals(ParsingException.class, e.getClass());
		}
	}

}
