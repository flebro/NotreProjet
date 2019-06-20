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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * Represent a simple console mode UI.
 */
public class ConsoleUI {

	/**
	 * Runs the application.
	 */
	public void run() {
		Scanner in = new Scanner(System.in);
		Calculator calculator = new CalculatorImp();
		Switch calculusSwitch = new Switch();
		CommandFactory commandFactory = new CommandFactory(calculator);
		Parser parser = new Parser();

		boolean quit = false;
		
		out.println("Bienvenue dans la calculatrice!");
		out.println("	tapez 'quit' pour quitter");
		out.println("	tapez 'history' pour afficher l'historique");
		out.print("\nEntrez votre premier calcul : ");

		do {
			try {
				ParsedInput parsedInput = parser.parseTokensList(in.nextLine());
				// We check if we received a method
				if (parsedInput.getMethods() != null) {
					switch (parsedInput.getMethods()) {
						case QUIT:
							quit = true;
							out.println("Au revoir!");
							break;
						case HISTORY:
							List<CalculationCommand> calculationCommands =
									calculusSwitch.getHistory();
							calculusSwitch.clear();
							runAndOutputCalculation(calculusSwitch, calculationCommands);
							break;
					}
				} else {
					if (parsedInput.isReset() == true) {
						calculusSwitch.clear();
					}
					// Else we run calculation
					List<CalculationCommand> calculationCommands =
							parsedInput.getInstructions().stream()
							.map(commandFactory::create).collect(Collectors.toList());
					runAndOutputCalculation(calculusSwitch, calculationCommands)
							.forEach(out::println);
				}
			} catch (ParsingException | CalculusException e) {
				out.println(e.getMessage());
				calculusSwitch.clear();
				out.println("L'historique a été vidé!");
			}
			if (!quit) {
				out.print("Nouveau calcul : ");
			}
		} while (!quit);
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
