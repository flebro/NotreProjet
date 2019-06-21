package com.notreprojet.back;

import com.notreprojet.back.front.ConsoleUI;

/**
 * Entry class of the application.
 */
public final class Application {

	private Application() { }

	public static void main(String[] args) {
		new ConsoleUI().run();
	}

}
