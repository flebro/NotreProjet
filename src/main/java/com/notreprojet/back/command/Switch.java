package com.notreprojet.back.command;

import com.notreprojet.back.calculus.exception.CalculusException;

/**
 * Our command pattern Switch responsible for the execution and storing of calculus commands.
 */
public class Switch {

	float state = 0;
	public float getState() {
		return state;
	}

	public float storeAndExecute(CalculationCommand calculationCommand) throws CalculusException {
		this.store(calculationCommand);
		state = calculationCommand.execute(state);
		return state;
	}
	
	public void clear() {
		this.state=0;
	}

	private void store(CalculationCommand calculationCommand) {}

}
