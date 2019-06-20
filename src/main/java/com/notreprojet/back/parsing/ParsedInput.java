package com.notreprojet.back.parsing;

import java.util.List;

/**
 * This class represents a parsed input.
 */
public class ParsedInput {

	private boolean reset;
	private List<Instruction> instructions;

	public boolean isReset() {
		return reset;
	}

	public void setReset(boolean reset) {
		this.reset = reset;
	}

	public List<Instruction> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}
}
