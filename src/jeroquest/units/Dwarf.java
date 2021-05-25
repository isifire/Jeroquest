package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Dwarf extends Hero {
	// initial values for the attributes
	protected static final int MOVEMENT = 6;
	protected static final int ATTACK = 1;
	protected static final int DEFENCE = 2;
	protected static final int BODY = 7;

	/**
	 * Create a dwarf from its name and the player name
	 * 
	 * @param name   dwarf's name
	 * @param player name of the player that controls it
	 */
	public Dwarf(String name, String player) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY, player, new Weapon("Hand axe", 2));

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
		return 'D';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Dwarf icon
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/dwarf.gif"));

	public Icon getImage() {
		return icon;
	}

}
