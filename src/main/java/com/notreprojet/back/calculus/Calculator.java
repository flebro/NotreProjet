package com.notreprojet.back.calculus;

import com.notreprojet.back.calculus.exception.CalculusException;

/**
 * Repository of the calculus methods.
 */
public interface Calculator {

	/**
	 * Performs an addition.
	 * @param first first member of the addition
	 * @param second first member of the addition
	 * @return the result of the addition
	 */
	float add(float first, float second);

	/**
	 * Performs a substraction.
	 * @param first first member of the division
	 * @param second first member of the division
	 * @return the result of the division
	 * @throws CalculusException
	 */
	float divide(float first, float second) throws CalculusException;

	/**
	 * Performs a multiplication.
	 * @param first first member of the multiplication
	 * @param second first member of the multiplication
	 * @return the result of the multiplication
	 */
	float multiply(float first, float second);

	/**
	 * Performs a substraction.
	 * @param first first member of the substraction
	 * @param second first member of the substraction
	 * @return the result of the substraction
	 */
	float sub(float first, float second);
	float sin(float first);
	float cos(float first);
	float tan(float first);
}
