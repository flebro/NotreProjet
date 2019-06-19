package com.notreprojet.back.command;

public interface CalculationSwitch {

	default float storeAndExecute(CalculationCommand calculationCommand) {
		this.store(calculationCommand);
		return calculationCommand.execute();
	}

	void store(CalculationCommand calculationCommand);

}
