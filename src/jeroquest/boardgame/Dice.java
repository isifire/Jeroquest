package jeroquest.boardgame;

/**
 * Programming Methodology Practice.
 * Jeroquest - An example of Object Oriented Programming.
 * Class Dice
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 * @version 1
 * 
 */

import java.util.Random; // random numbers generator

public class Dice {

	private static Random generator = new Random(); // random numbers generator

	/**
	 * Sets the seed to generate random numbers
	 * @param seed the initial seed
	 */
	public static void setSeed(long seed) {
		generator.setSeed(seed);
	}

	/**
	 * Rolls a 6 sides dice: 1D6
	 * 
	 * @return the result of rolling the 1D6
	 */
	public static int roll() {
		return roll(6); // by default 6 sides
	}

	/**
	 * Rolls a N sides dice
	 * 
	 * @param sides The number of sides: 1DN
	 * @return the result of rolling the 1DN
	 */
	public static int roll(int sides) // it needs the number of sides
	{
		return generator.nextInt(sides) + 1;
	}

	/**
	 * Function to test empirically that all sides in the dice are equally probable
	 */
	public static void testDice() {
		final int TRIES = 1000000;
		double totals[] = { 0, 0, 0, 0, 0, 0 };
		for (int x = 0; x < TRIES; x++)
			totals[roll() - 1]++;
		for (int x = 0; x < 6; x++)
			System.out.printf("%d: %f\n", x, totals[x] / TRIES);
	}
}