package com.notreprojet.back.calculus;

import com.notreprojet.back.calculus.exception.CalculusException;

public interface Calculator {

	float add(float first, float second);
	float divide(float first, float second) throws CalculusException;
	float multiply(float first, float second);
	float sub(float first, float second);

}
