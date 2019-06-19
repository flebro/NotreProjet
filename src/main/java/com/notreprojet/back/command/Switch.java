package com.notreprojet.back.command;

public class Switch {

	float state = 0;
	public float getState() {
		return state;
	}

	public float storeAndExecute(CalculationCommand calculationCommand) {
		this.store(calculationCommand);
		state = calculationCommand.execute(state);
		return state;
	}

	private void store(CalculationCommand calculationCommand) {}

}
