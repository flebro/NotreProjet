package com.notreprojet.back.command;

import com.notreprojet.back.calculus.exception.CalculusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Our command pattern Switch responsible for the execution and storing of calculus commands.
 */
public class Switch {

	private transient float state;

	/**
	 * Gets this instance state.
	 * @return
	 */
	public float getState() {
		return state;
	}

	private transient List<CalculationCommand> history;

	/**
	 * Get this instance commands history.
	 * @return
	 */
	public List<CalculationCommand> getHistory() {
		return history;
	}

	private transient SwitchCareTaker careTaker;

	/**
	 * Default constructor.
	 */
	public Switch() {
		this.state = 0;
		this.history = new ArrayList<>();
		this.careTaker = new SwitchCareTaker();
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
		this.careTaker.add(saveStateToMemento());
		this.state = 0;
		this.history = new ArrayList<>();
	}

	private void store(CalculationCommand calculationCommand) {
		history.add(calculationCommand);
	}

	/**
	 * Saves the current switch state to a memento.
	 * @return
	 */
	public SwitchMemento saveStateToMemento() {
		return new SwitchMemento(getHistory());
	}

	/**
	 * Gets the full calculation commands history since this switch instanciation.
	 * @return
	 */
	public List<CalculationCommand> getFullHistory() {
		return Stream.concat(this.careTaker.getAll().stream()
				.map(SwitchMemento::getCommands)
				.flatMap(List::stream),
				history.stream())
				.collect(Collectors.toList());
	}

}
