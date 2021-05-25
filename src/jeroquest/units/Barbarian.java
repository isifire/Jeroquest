package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Barbarian extends Hero {
	// initial values for the attributes
	protected static final int MOVEMENT = 7;
	protected static final int ATTACK = 1;
	protected static final int DEFENCE = 2;
	protected static final int BODY = 8;

	/**
	 * Create a barbarian from its name and the player name
	 * 
	 * @param name   barbarian's name
	 * @param player name of the player that controls it
	 */
	public Barbarian(String name, String player) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY, player, new Weapon("Broadsword", 3));
	}

	/************************************************
	 * Interface Piece implementation
	 **********************************************/

	/**
	 * Generate a text representation of the character in the board (implementing an
	 * abstract method)
	 * 
	 * @return the text representation of the object in the board
	 */
	public char toChar() {
		return 'B';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Barbarian icon
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/barbarian.gif"));

	public Icon getImage() {
		return icon;
	}

}
