package com.notreprojet.back.front;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.CalculatorImp;
import com.notreprojet.back.calculus.exception.CalculusException;
import com.notreprojet.back.command.AddCommand;
import com.notreprojet.back.command.SubCommand;
import com.notreprojet.back.command.CalculationCommand;
import com.notreprojet.back.command.DivideCommand;
import com.notreprojet.back.command.MultiplyCommand;
import com.notreprojet.back.command.Switch;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class ConsoleUI {

	public void run() {
		Scanner in = new Scanner(System.in);
		Calculator calculator = new CalculatorImp();
		Switch calculusSwitch = new Switch();
		String[] args = null;
		
		System.out.println("Bienvenue sur la calculatrice.");
		System.out.print("Entrez votre premier calcul : ");

		do {
			args = in.nextLine().toLowerCase().split(" ");

			int compteur = 0;
			try {
				if (StringUtils.isNumeric(args[0])) {
					calculusSwitch.storeAndExecute(new AddCommand(calculator, NumberUtils.toFloat(args[0])));
					compteur++;
				}
				while (compteur < args.length) {
					String token = args[compteur];

					if ("+".equals(token)) {
						compteur++;
						if (args.length > compteur) {
							float member = NumberUtils.toFloat(args[compteur]);
							calculusSwitch.storeAndExecute(new AddCommand(calculator, member));
						}
					} else if ("/".equals(token)) {
						compteur++;
						if (args.length > compteur) {
							float member = NumberUtils.toFloat(args[compteur]);
							calculusSwitch.storeAndExecute(new DivideCommand(calculator, member));
						}
					} else if ("*".equals(token)) {
						compteur++;
						if (args.length > compteur) {
							float member = NumberUtils.toFloat(args[compteur]);
							calculusSwitch.storeAndExecute(new MultiplyCommand(calculator, member));
						}
					} else if (args[compteur].equals("-")) {
						compteur++;
						if (args.length > compteur) {
							float member = NumberUtils.toFloat(args[compteur]);
							calculusSwitch.storeAndExecute(new SubCommand(calculator, member));
						}
					}
					compteur++;
				}
				System.out.println("Resultat : " + calculusSwitch.getState());
				System.out.print("Calcul suivant : ");
			} catch (CalculusException cex) {
				System.out.println("Erreur : " + cex.getMessage());
			}
		} while (args.length > 0 && !args[0].toLowerCase().equals("exit"));
	}

}
