package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Goblin extends Monster {

	// initial values for the attributes
	protected static final int MOVEMENT = 10;
	protected static final int ATTACK = 2;
	protected static final int DEFENCE = 1;
	protected static final int BODY = 1;

	/**
	 * Create a goblin from its name
	 * 
	 * @param name goblin's name
	 */
	public Goblin(String name) {
		super(name, MOVEMENT, ATTACK, DEFENCE, BODY);
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
		return 'G';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Goblin icon
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/goblin.png"));

	public Icon getImage() {
		return icon;
	}

}
