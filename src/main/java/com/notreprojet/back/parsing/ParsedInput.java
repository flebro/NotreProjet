package com.notreprojet.back.parsing;

import java.util.List;

/**
 * This class represents a parsed input.
 */
public class ParsedInput {

	private boolean reset;
	private List<Instruction> instructions;
	private Methods methods;

	/**
	 * Gets the reset flag.
	 * @return the reset flag
	 */
	public boolean isReset() {
		return reset;
	}

	/**
	 * Sets the reset flag.
	 * @param reset the reset flag
	 */
	public void setReset(boolean reset) {
		this.reset = reset;
	}

	/**
	 * Gets the parsed instructions.
	 * @return the parsed instructions
	 */
	public List<Instruction> getInstructions() {
		return instructions;
	}

	/**
	 * Sets the parsed instructions.
	 * @param instructions the parsed instructions
	 */
	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	/**
	 * Gets the parsed methods.
	 * @return the parsed methods
	 */
	public Methods getMethods() {
		return methods;
	}

	/**
	 * Sets the parsed methods.
	 * @param methods the parsed methods
	 */
	public void setMethods(Methods methods) {
		this.methods = methods;
	}
}
