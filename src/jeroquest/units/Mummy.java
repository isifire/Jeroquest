package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Mummy extends Monster {

	// initial values for the attributes
	protected static final int MOVEMENT = 4;
	protected static final int ATTACK = 3;
	protected static final int DEFENCE = 4;
	protected static final int BODY = 2;

	/**
	 * Create a mummy from its name
	 * 
	 * @param name name of the mummy
	 */
	public Mummy(String name) {
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
		return 'M';
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Icon of a mummy
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/mummy.gif"));

	public Icon getImage() {
		return icon;
	}

}
