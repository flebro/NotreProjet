package com.notreprojet.back.command;

import com.notreprojet.back.calculus.exception.CalculusException;
import com.notreprojet.back.parsing.Operators;

/**
 * Constract representing a calculus command.
 */
public interface CalculationCommand {

	/**
	 * Gets this command operator.
	 * @return
	 */
	Operators getOperator();

	/**
	 * Gets this command member.
	 * @return
	 */
	float getMember();

	/**
	 * Execute the calculus represented by this command.
	 * @param number
	 * @return
	 * @throws CalculusException
	 */
	float execute(float number) throws CalculusException;

}
