package jeroquest.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Static class MyKeyboard to have access to the pressed keys in the keyboard
 * from the text console. (The windows have a different system, based on events,
 * to detect user interaction)
 * 
 * @author Programming Methodology Professors
 *
 */
public class MyKeyboard {

	/**
	 * Default constructor, private to avoid creating objects of this class
	 */
	private MyKeyboard() {

	}

	/**
	 * Waits until the Enter key is pressed
	 */
	static public void pressEnter() {

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press Enter to continue");
		try {
			keyboard.readLine();
		} catch (IOException ex1) {
		}
	}
}
