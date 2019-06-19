package com.notreprojet.back.front;

import com.notreprojet.back.calculus.Calculator;
import com.notreprojet.back.calculus.CalculatorImp;
import com.notreprojet.back.command.AddCommand;
import com.notreprojet.back.command.SubCommand;
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

		do {
			args = in.nextLine().toLowerCase().split(" ");

			int compteur = 0;

			if (StringUtils.isNumeric(args[0])) {
				calculusSwitch.storeAndExecute(new AddCommand(calculator, NumberUtils.toFloat(args[0])));
				compteur++;
			}
			while (compteur < args.length) {

				if (args[compteur].equals("+")) {
					compteur++;
					if (args.length > compteur) {
						float member = NumberUtils.toFloat(args[compteur]);
						calculusSwitch.storeAndExecute(new AddCommand(calculator, member));
					}
				}
				if (args[compteur].equals("-")) {
					compteur++;
					if (args.length > compteur) {
						float member = NumberUtils.toFloat(args[compteur]);
						calculusSwitch.storeAndExecute(new SubCommand(calculator, member));
					}
				}	
				compteur++;
			}

			System.out.println("Resultat : " + calculusSwitch.getState());
		} while (args.length > 0 && !args[0].toLowerCase().equals("exit"));
	}

}
