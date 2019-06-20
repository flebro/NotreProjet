package com.notreprojet.back.command;

import com.notreprojet.back.calculus.exception.CalculusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Our command pattern Switch responsible for the execution and storing of calculus commands.
 */
public class Switch {

	transient float state;
	public float getState() {
		return state;
	}

	List<CalculationCommand> history;

	/**
	 * Get this instance commands history.
	 * @return
	 */
	public List<CalculationCommand> getHistory() {
		return history;
	}

	/**
	 * Default constructor.
	 */
	public Switch() {
		state = 0;
		history = new ArrayList<>();
	}

	/**
	 * Stores then execute a calculation command.
	 * @param calculationCommand
	 * @return
	 * @throws CalculusException
	 */
	public float storeAndExecute(CalculationCommand calculationCommand) throws CalculusException {
		this.store(calculationCommand);
		state = calculationCommand.execute(state);
		return state;
	}

	/**
	 * Clears the switch history.
	 */
	public void clear() {
		this.state = 0;
		this.history = new ArrayList<>();
	}

	private void store(CalculationCommand calculationCommand) {
		history.add(calculationCommand);
	}

}
