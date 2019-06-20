package com.notreprojet.back.front;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.CalculatorImp;
import com.notreprojet.back.calculus.exception.CalculusException;
import com.notreprojet.back.command.CalculationCommand;
import com.notreprojet.back.command.CommandFactory;
import com.notreprojet.back.command.Switch;
import com.notreprojet.back.parsing.ParsedInput;
import com.notreprojet.back.parsing.Parser;
import com.notreprojet.back.parsing.ParsingException;

import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * Represent a simple console mode UI.
 */
public class ConsoleUI {

	public void run() {
		Scanner in = new Scanner(System.in);
		Calculator calculator = new CalculatorImp();
		Switch calculusSwitch = new Switch();
		CommandFactory commandFactory = new CommandFactory(calculator);
		Parser parser = new Parser();

		do {
			try {
				ParsedInput parsedInput = parser.parseTokensList(in.nextLine());
				for (CalculationCommand calculationCommand : parsedInput.getInstructions().stream()
						.map(commandFactory::create).collect(Collectors.toList())) {
					calculusSwitch.storeAndExecute(calculationCommand);
				}
				out.println("Resultat : " + calculusSwitch.getState());
			} catch (ParsingException | CalculusException e) {
				out.println(e.getMessage());
				calculusSwitch.clear();
			}
		} while (true);
	}
}
