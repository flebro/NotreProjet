package com.notreprojet.back.parsing;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * This class is responsible of parsing a input into instructions.
 */
public class Parser {

	/**
	 * Parse an string input representing a list of tokens.
	 * @param input the input string to parse
	 * @return an object representation of the parsed input
	 * @throws ParsingException if the input string violates parsing rules
	 */
	public ParsedInput parseTokensList(String input) throws ParsingException {
		ParsedInput parsedInput = new ParsedInput();
		List<Instruction> instructions = new ArrayList<>();
		Optional<Token> previous = Optional.empty();
		for (String token : input.trim().toLowerCase(Locale.getDefault()).split(" ")) {
			Token parsedToken = parseToken(token);
			if (Methods.class.equals(parsedToken.getValueClass())) {
				if (CollectionUtils.isNotEmpty(instructions) 
						|| previous.isPresent()) {
					throw new ParsingException("A method should be the only token present");
				} else {
					parsedInput.setMethods((Methods) parsedToken.getValue());
					break;
				}
			}

			if (instructions.isEmpty() && !previous.isPresent() 
					&& Float.class.equals(parsedToken.getValueClass())) {
				instructions.add(new Instruction(Operators.PLUS, (Float) parsedToken.getValue()));
				parsedInput.setReset(true);
			} else if (previous.isPresent() 
					&& Float.class.equals(parsedToken.getValueClass())) {
				Instruction instruction = new Instruction(
						(Operators) previous.get().getValue(),
						(Float) parsedToken.getValue());
				instructions.add(instruction);
				previous = Optional.empty();
			} else {
				if (Operators.class.equals(parsedToken.getValueClass())) {
					previous = Optional.of(parsedToken);
				} else {
					throw new ParsingException("The input can not have two consecutive operators");
				}
			}
		}

		parsedInput.setInstructions(instructions);

		return parsedInput;
	}

	/**
	 * Parses a string token in a recognized token.
	 * @param token string token to analyze
	 * @return the parsed token
	 * @throws ParsingException if the string token does not match a recognized token
	 */
	public Token parseToken(String token) throws ParsingException {
		Optional<Operators> optionalOperators = Operators.fromToken(token);
		if (optionalOperators.isPresent()) {
			return new Token<>(optionalOperators.get());
		}
		Optional<Methods> methods = Methods.fromToken(token);
		if (methods.isPresent()) {
			return new Token<>(methods.get());
		}
		if (StringUtils.isNumeric(token)) {
			return new Token<>(NumberUtils.toFloat(token));
		} else {
			throw new ParsingException(
					"The following token is neither a numeric or an operator : " + token);
		}
	}

}
