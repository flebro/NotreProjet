package com.notreprojet.back.command;

import java.util.List;

/**
 * This object is used to memorize a switch state.
 */
public class SwitchMemento {

	private final transient List<CalculationCommand> commands;

	/**
	 * Gets the memorized commands.
	 * @return
	 */
	public List<CalculationCommand> getCommands() {
		return commands;
	}

	/**
	 * Creates a memnto from a list of commands.
	 * @param commands
	 */
	public SwitchMemento(List<CalculationCommand> commands) {
		this.commands = commands;
	}

}
