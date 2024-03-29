package com.notreprojet.back.calculus;

import com.notreprojet.back.calculus.exception.CalculusException;

/**
 * Implementation of the calculus repository.
 */
public class CalculatorImp implements Calculator {

	@Override
	public float add(float first, float second) {
		return first + second;
	}

	@Override
	public float multiply(float first, float second) {
		return first * second;
	}

	@Override
	public float sub(float first, float second) {
		return first - second;
	}

	@Override
	public float divide(float first, float second) throws CalculusException {
		if (second == 0) {
			throw new CalculusException("Can't divide by zero !");
		} else {
			return first / second;
		}
	}
	
	@Override
	public float sin(float first) {
		return (float) Math.sin(first);
	}
	
	@Override
	public float cos(float first) {
		return (float) Math.cos(first);
	}
	
	@Override
	public float tan(float first) {
		return (float) Math.tan(first);
	}

}
