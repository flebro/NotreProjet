package com.notreprojet.back.command;

import com.notreprojet.back.calculus.exception.CalculusException;

public interface CalculationCommand {

	float execute(float number) throws CalculusException;

}
