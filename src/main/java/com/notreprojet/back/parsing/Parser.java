package com.notreprojet.back.parsing;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * This class is responsible of parsing a input into instructions.
 */
public class Parser {

	public ParsedInput parseTokensList(String input) throws ParsingException {
		ParsedInput parsedInput = new ParsedInput();
		List<Instruction> instructions = new ArrayList<>();
		Token previous = null;
		for (String token : input.trim().toLowerCase(Locale.getDefault()).split(" ")) {
			Token parsedToken = parseToken(token);
			if (instructions.isEmpty() && previous == null &&
					Float.class.equals(parsedToken.getValueClass())) {
				instructions.add(new Instruction(Operators.PLUS, (Float) parsedToken.getValue()));
				parsedInput.setReset(true);
			} else if (previous == null) {
				if (!Operators.class.equals(parsedToken.getValueClass())) {
					throw new ParsingException("");
				} else {
					previous = parsedToken;
				}
			} else if (Float.class.equals(parsedToken.getValueClass())) {
				Instruction instruction = new Instruction(
						(Operators) previous.getValue(),
						(Float) parsedToken.getValue());
				instructions.add(instruction);
				previous = null;
			}
		}

		if (previous != null) {
			throw new ParsingException("An operator should always be followed by a number");
		}

		parsedInput.setInstructions(instructions);

		return parsedInput;
	}

	public Token parseToken(String token) throws ParsingException {
		Optional<Operators> optionalOperators = Operators.fromToken(token);
		if (optionalOperators.isPresent()) {
			return new Token<>(optionalOperators.get());
		}
		if (StringUtils.isNumeric(token)) {
			return new Token<>(NumberUtils.toFloat(token));
		} else {
			throw new ParsingException(
					"The following token is neither a numeric or an operator : " + token);
		}
	}

}
