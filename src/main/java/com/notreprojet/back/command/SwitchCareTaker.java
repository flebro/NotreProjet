package com.notreprojet.back.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible to save and restore switch states.
 */
public class SwitchCareTaker {

	private transient List<SwitchMemento> mementoList = new ArrayList<>();

	/**
	 * Saves a switch state.
	 * @param memento switch state to save
	 */
	public void add(SwitchMemento memento) {
		mementoList.add(memento);
	}

	/**
	 * Gets all memorized states.
	 * @return all memorized states
	 */
	public List<SwitchMemento> getAll() {
		return Collections.unmodifiableList(mementoList);
	}

}
