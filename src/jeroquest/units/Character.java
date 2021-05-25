package jeroquest.units;

/**
 * Programming Methodology Practice.
 * Jeroquest - An example of Object Oriented Programming.
 * Class Character
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import jeroquest.boardgame.Dice;
import jeroquest.boardgame.Piece;
import jeroquest.boardgame.XYLocation;
import jeroquest.gui.GraphicElement;
import jeroquest.gui.MyJLabelCharacter;
import jeroquest.gui.MyKeyboard;
import jeroquest.gui.MyPanelBoard;
import jeroquest.logic.Game;
import jeroquest.logic.Jeroquest;
import jeroquest.utils.DynamicVectorCharacters;
import jeroquest.utils.DynamicVectorXYLocation;

public abstract class Character implements Piece, GraphicElement {
	// attributes with the current values for the character
	private int movement; // units of movement per turn
	private int attack; // total of attack dices
	private int defence; // total of defence dices
	private int body; // body points

	// attributes with the initial values for the character
	private int movementInitial; // units of movement per turn
	private int attackInitial; // total of attack dices
	private int defenceInitial; // total of defence dices
	private int bodyInitial; // body points

	private String name; // character's name

	/**
	 * Create a character from its name and its initial values for the attributes,
	 * initially its position is null (outside of the board)
	 * 
	 * @param name     character's name
	 * @param movement units of movement per turn
	 * @param attack   total of attack dices
	 * @param defence  total of defence dices
	 * @param body     body points
	 */
	public Character(String name, int movement, int attack, int defence, int body) {

		this.name = name;

		// setting the initial values
		this.movementInitial = movement;
		this.attackInitial = attack;
		this.defenceInitial = defence;
		this.bodyInitial = body;

		// setting the current values
		this.movement = movement;
		this.attack = attack;
		this.defence = defence;
		this.body = body;

		// null position (outside of the board)
		this.position = null;
	}

	/**
	 * Get the units of movement per turn
	 * 
	 * @return character's units of movement
	 */
	public int getMovement() {
		return movement;
	}

	/**
	 * Get the dices for attack
	 * 
	 * @return character's attack dices
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Get the dices for defence
	 * 
	 * @return character's defence dices
	 */
	public int getDefence() {
		return defence;
	}

	/**
	 * Get the body points
	 * 
	 * @return character's body points
	 */
	public int getBody() {
		return body;
	}

	/**
	 * Getter for movementInitial
	 * 
	 * @return movementInitial
	 */
	public int getMovementInitial() {
		return movementInitial;
	}

	/**
	 * Getter for attackInitial
	 * 
	 * @return attackInitial
	 */
	public int getAttackInitial() {
		return attackInitial;
	}

	/**
	 * Getter for defenceInitial
	 * 
	 * @return defenceInitial
	 */
	public int getDefenceInitial() {
		return defenceInitial;
	}

	/**
	 * Getter for bodyInitial
	 * 
	 * @return bodyInitial
	 */
	public int getBodyInitial() {
		return bodyInitial;
	}

	/**
	 * Get the name
	 * 
	 * @return the name of the character
	 */
	public String getName() {
		return name;
	}

	protected void setMovement(int movement) {
		this.movement = movement;
	}

	protected void setAttack(int attack) {
		this.attack = attack;
	}

	protected void setDefence(int defence) {
		this.defence = defence;
	}

	protected void setBody(int body) {
		this.body = body;
	}

	protected void setMovementInitial(int movementInitial) {
		this.movementInitial = movementInitial;
	}

	protected void setAttackInitial(int attackInitial) {
		this.attackInitial = attackInitial;
	}

	protected void setDefenceInitial(int defenceInitial) {
		this.defenceInitial = defenceInitial;
	}

	protected void setBodyInitial(int bodyInitial) {
		this.bodyInitial = bodyInitial;
	}

	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * Checks if a character has any body points left
	 * 
	 * @return true if it is alive, false otherwise
	 */
	public boolean isAlive() {
		return body > 0;
	}

	/**
	 * Computes the number of impacts that the attack of the character will make,
	 * for that it rolls as many dices as dictated by the attribute attack
	 * 
	 * @return the number of impacts made
	 */
	public int attack() {
		int impacts = 0;
		for (int x = 0; x < getAttack(); x++)
			if (Dice.roll() > 3)
				impacts++;
		return impacts;
	}

	/**
	 * Simulates an combat with other character, it does the attack and the defence.
	 * If the attack kills the opponent it is moved out of the board
	 * 
	 * @param c           character being attacked
	 * @param currentGame the current game
	 */
	public void combat(Character c, Game currentGame) { // attacks to c and c defends itself
		c.defend(this.attack());
		if (!c.isAlive()) {
			currentGame.getBoard().removePiece(c);
		}
	}

	/**
	 * Defence from an attack (abstract method: each subclass must define its own
	 * behaviour)
	 * 
	 * @param impacts total number of impacts to try to block or suffer
	 * @return the number of suffered wounds
	 */
	public abstract int defend(int impacts);

	/**
	 * Checks that the character given as argument is an enemy. An enemy is any
	 * character that is not of the same type
	 * 
	 * @param c character to test the hostility
	 * @return true if it is an enemy
	 */
	public boolean isEnemy(Character c) {
		return this.getClass() != c.getClass();
	}

	/**
	 * Combat action for the character
	 * 
	 * @param currentGame game in which the character has to act
	 * @return true if the character has to fight an enemy, false otherwise
	 */
	public boolean actionCombat(Game currentGame) {
		// Attack a random enemy
		DynamicVectorCharacters targets = validTargets(currentGame);

		if (targets.length() > 0) {
			Character target = targets.get(Dice.roll(targets.length()) - 1);

			System.out.println(
					this.getName() + this.getPosition() + " attacks to " + target.getName() + target.getPosition());
			this.combat(target, currentGame);
			return true;
		}
		return false;
	}

	/**
	 * Movement action for the character
	 * 
	 * @param currentGame game in which the character has to act
	 * @return the number of squares that it has moved
	 */
	public int actionMovement(Game currentGame) {
		// Random movement in the board
		System.out.print(this.getName() + this.getPosition() + " moves to ");
		DynamicVectorXYLocation validPositions = validPositions(currentGame);
		int mov = this.getMovement();
		while ((validPositions.length() > 0) && (mov > 0)) {
			// if it can it moves in a direction chosen randomly
			XYLocation newPosition = validPositions.get(Dice.roll(validPositions.length()) - 1);
			currentGame.getBoard().movePiece(this, newPosition);
			mov--;
			System.out.println(this.getPosition());

			// window
			Jeroquest.showGame();
			MyKeyboard.pressEnter();

			validPositions = validPositions(currentGame);
		}

		if (Jeroquest.blocked(currentGame, this))
			System.out.print("<<<BLOCKED");
		System.out.println();
		// window
		Jeroquest.showGame();
		MyKeyboard.pressEnter();

		return this.getMovement() - mov;
	}

	/**
	 * AI: character's Artificial Intelligence It does the actions in a given turn:
	 * attack and movement
	 * 
	 * @param currentGame game in which the character has to act
	 */
	public void resolveTurn(Game currentGame) {

		// Attack to a random enemy
		actionCombat(currentGame);

		// Move randomly through the board
		actionMovement(currentGame);

		// Possibles improvement (among others):
		// - Move towards the closest enemy / with less body points /...
		// A.- First in Xs and later in Ys
		// B.- First in the coordinate with difference with the target's position
		// - AI: check if there is free way until the target
		// - What to do if our way is blocked by allies?
		// - Stop is there is an enemy at attack range
		// and if the square is free and inside of the board move to that position

	}

	/**
	 * Returns an array with the valid targets for this character
	 * 
	 * @param currentGame the current game
	 * @return the valid targets for the character in its current position
	 */
	public DynamicVectorCharacters validTargets(Game currentGame) {
		// search targets
		DynamicVectorCharacters validTargets = new DynamicVectorCharacters();

		// It needs to iterate the characters in the game and add the valid targets,
		// that is:
		// 1.- the ones alive
		// 2.- that are enemies
		// 3.- that are at attack range
		for (Character character : currentGame.getCharacters()) {
			if (character.isAlive()) {
				if (isEnemy(character)) {
					if (isAtRange(character.getPosition()))
						validTargets.add(character);
				}
			}
		}

		return validTargets;
	}

	/**
	 * Check if the character at position pos is at attack range
	 * 
	 * @param pos position of the second character
	 * @return true is the squares are adjacent, false otherwise
	 */
	public boolean isAtRange(XYLocation pos) {
		// pos to the North from this character
		if ((this.getPosition().getX() == pos.getX() - 1) && (this.getPosition().getY() == pos.getY()))
			return true;

		// po to the South from this character
		if ((this.getPosition().getX() == pos.getX() + 1) && (this.getPosition().getY() == pos.getY()))
			return true;

		// pos to the East from this character
		if ((this.getPosition().getY() == pos.getY() - 1) && (this.getPosition().getX() == pos.getX()))
			return true;

		// pos2 to the West from this character
		if ((this.getPosition().getY() == pos.getY() + 1) && (this.getPosition().getX() == pos.getX()))
			return true;

		return false;
	}

	/**
	 * Returns an array with the valid squares where a character can move directly
	 * from its current position:(N, S, E and W)
	 * 
	 * @param currentGame game that contains the board and the characters
	 * @return the vector of positions (possibly free) where it can move
	 */
	public DynamicVectorXYLocation validPositions(Game currentGame) {

		DynamicVectorXYLocation positions = new DynamicVectorXYLocation();

		XYLocation position = this.getPosition().south();
		if (currentGame.getBoard().freeSquare(position))
			positions.add(position);

		position = this.getPosition().west();
		if (currentGame.getBoard().freeSquare(position))
			positions.add(position);

		position = this.getPosition().east();
		if (currentGame.getBoard().freeSquare(position))
			positions.add(position);

		position = this.getPosition().north();
		if (currentGame.getBoard().freeSquare(position))
			positions.add(position);

		return positions;
	}

	/**
	 * Generate a printable representation of the object (overridden method)
	 * 
	 * @return The printable representation of the character
	 */
	@Override
	public String toString() {
		return String.format("%s (moves:%d attack:%d defence:%d body:%d/%d)", getName(), getMovement(), getAttack(),
				getDefence(), getBody(), getBodyInitial());
	}

	/************************************************
	 * Interface GraphicElement implementation
	 **********************************************/

	// Icon for an abstract character
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/unknown.png"));

	/**
	 * Returns the icon associated to an abstract character
	 * 
	 * @return the icon associated to the class Character
	 */
	public Icon getImage() {
		return icon;
	}

	/**
	 * Shows an icon representing the character in the layer 2
	 * 
	 * @param w graphic panel to show the icon
	 */
	public void show(MyPanelBoard w) {
		XYLocation pos = getPosition();
		// if the character is dead is outside of the board
		if (pos != null) {
			// a JLabel is created the icon
			JLabel lab = new MyJLabelCharacter(this);

			// the label is added to the layer 2
			w.add(lab, Integer.valueOf(2));
		}

	}

	/************************************************
	 * Interface Piece implementation
	 **********************************************/
	// by composition
	private XYLocation position; // position in the board

	/**
	 * Get the position in the board
	 * 
	 * @return the position of the character in the board
	 */
	public XYLocation getPosition() {
		return position;
	}

	/**
	 * Set the position of the character in the board
	 * 
	 * @param pos new position of the character in the board
	 */
	public void setPosition(XYLocation pos) {
		position = pos;
	}

	/**
	 * Generate a text version to represent the character in the board
	 * 
	 * @return a text (as char) representation of the character
	 */
	public char toChar() {
		// if the subclass doesn't change it, the characters will appear
		// as '?'s
		return '?';
	}

}
