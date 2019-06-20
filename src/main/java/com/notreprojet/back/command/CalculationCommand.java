package com.notreprojet.back.command;

import com.notreprojet.back.calculus.exception.CalculusException;

/**
 * Constract representing a calculus command.
 */
public interface CalculationCommand {

	float execute(float number) throws CalculusException;

}
