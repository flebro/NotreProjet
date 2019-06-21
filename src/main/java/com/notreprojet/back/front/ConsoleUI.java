package com.notreprojet.back.front;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.CalculatorImp;
import com.notreprojet.back.calculus.exception.CalculusException;
import com.notreprojet.back.command.CalculationCommand;
import com.notreprojet.back.command.CommandFactory;
import com.notreprojet.back.command.Switch;
import com.notreprojet.back.parsing.Methods;
import com.notreprojet.back.parsing.ParsedInput;
import com.notreprojet.back.parsing.Parser;
import com.notreprojet.back.parsing.ParsingException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Represent a simple console mode UI.
 */
public class ConsoleUI {

	/**
	 * Runs the application.
	 */
	public void run() {
		Scanner inScanner = new Scanner(System.in);
		Calculator calculator = new CalculatorImp();
		Switch calculusSwitch = new Switch();
		CommandFactory commandFactory = new CommandFactory(calculator);
		Parser parser = new Parser();

		boolean quit;
		
		out.println("Bienvenue dans la calculatrice!");
		out.println("	tapez 'quit' pour quitter");
		out.println("	tapez 'history' pour afficher l'historique");
		out.println("	tapez 'sumhistory' pour faire la somme de l'historique complet");

		do {
			String input = inScanner.nextLine();
			List<String> outputs = handleInput(input, parser, calculusSwitch, commandFactory);
			outputs.forEach(out::println);
			quit = outputs.isEmpty();
		} while (!quit);
		out.println("Au revoir!");
	}

	/**
	 * Handles a string input.
	 * @param input input to handle
	 * @param parser parser to parse the input
	 * @param calculusSwitch switch to run calculus
	 * @param commandFactory command producer
	 * @return the list of outputs generated from input
	 */
	public List<String> handleInput(String input,
									Parser parser,
									Switch calculusSwitch,
									CommandFactory commandFactory) {
		List<String> outputs = new ArrayList<>();
		try {
			ParsedInput parsedInput = parser.parseTokensList(input);
			// We check if we received a method
			if (parsedInput.getMethods() == null) {
				if (parsedInput.isReset()) {
					calculusSwitch.clear();
					outputs.add("Nouveau calcul : ");
				}
				// Else we run calculation
				List<CalculationCommand> calculationCommands =
						commandFactory.createFromParsedInput(parsedInput);
				runAndOutputCalculation(calculusSwitch, calculationCommands)
						.forEach(outputs::add);
			} else {
				return handleMethod(parsedInput.getMethods(), calculusSwitch);
			}
		} catch (ParsingException | CalculusException e) {
			outputs.add(e.getMessage());
			calculusSwitch.clear();
			outputs.add("L'historique a été vidé!");
		}
		return outputs;
	}

	/**
	 * Handles a method input.
	 * @param method method to handle
	 * @param calculusSwitch active switch
	 * @return boolean that indicates if the application should stop
	 * @throws CalculusException if there is an exception while running the history
	 */
	public List<String> handleMethod(Methods method, Switch calculusSwitch) throws CalculusException {
		List<String> outputs = new ArrayList<>();
		List<CalculationCommand> calculationCommands;
		switch (method) {
			case QUIT:
				break;
			case HISTORY:
				calculationCommands = calculusSwitch.getHistory();
				calculusSwitch.clear();
				runAndOutputCalculation(calculusSwitch, calculationCommands).forEach(outputs::add);
				break;
			case SUM_HISTORY:
				calculationCommands = calculusSwitch.getFullHistory();
				calculusSwitch.clear();
				runAndOutputCalculation(calculusSwitch, calculationCommands).forEach(outputs::add);
				break;
			default:
				break;
		}
		return outputs;
	}

	/**
	 * Runs and store a list of calculation commands through a switch.
	 * @param calculusSwitch switch that will execute commands
	 * @param calculationCommands commands to execute
	 * @throws CalculusException if the calculus encounters an error
	 */
	public List<String> runAndOutputCalculation(
			Switch calculusSwitch, List<CalculationCommand> calculationCommands)
			throws CalculusException {
		List<String> outputs = new ArrayList<>();
		Iterator<CalculationCommand> iterator = calculationCommands.iterator();
		while (iterator.hasNext()) {
			CalculationCommand calculationCommand = iterator.next();
			calculusSwitch.storeAndExecute(calculationCommand);
			outputs.add(MessageFormat.format(
					"{0} {1} = {2}",
					calculationCommand.getOperator().getToken(),
					calculationCommand.getMember(),
					calculusSwitch.getState()));
		}
		return outputs;
	}

}
