package jeroquest.units;

import jeroquest.boardgame.Dice;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class Hero - abstract class that represents the heroes in the
 * game
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

public abstract class Hero extends Character {
	private String player; // name of the player that controls the hero
	private Weapon weapon; // weapon that arms the hero

	/**
	 * Create a Hero from its name and initial values for the attributes, initially
	 * its position is null (outside of the board)
	 * 
	 * @param name     name of the character
	 * @param movement squares to move per turn
	 * @param attack   dices to roll for an attack without a weapon
	 * @param defence  dices to roll for the defence
	 * @param body     initial life
	 * @param player   the name of the player that controls this hero
	 * @param weapon   the initial weapon
	 */

	public Hero(String name, int movement, int attack, int defence, int body, String player, Weapon weapon) {
		super(name, movement, attack, defence, body);
		this.player = player;
		this.setWeapon(weapon);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	@Override
	public int getAttack() {
		if (getWeapon() != null)
			return getWeapon().getAttack();
		else
			return super.getAttack();
	}

	/**
	 * Set the current weapon of the hero
	 * 
	 * @param weapon weapon to set (it can be null if we want to take out the
	 *               current one)
	 */
	public void setWeapon(Weapon weapon) {
		// set the current weapon
		this.weapon = weapon;
	}

	/**
	 * The hero defends itself from an attack (Implementation of an abstract
	 * inherited method)
	 * 
	 * @param impacts the total number of impacts to try to block or suffer
	 * @return the number of suffered wounds
	 */
	public int defend(int impacts) {
		int wounds = 0;

		// it tries to block the impacts with the defence
		for (int totalDefenceDices = getDefence(); (impacts > 0) && (totalDefenceDices > 0); totalDefenceDices--)
			if (Dice.roll() > 4) // a 5 or 6 necessary to block an impact
				impacts--;

		// if any unblocked impact, decrement body points
		if (impacts > 0) {
			// the life of a character cannot be lower then zero
			wounds = Math.min(getBody(), impacts);
			setBody(getBody() - wounds);
			System.out.printf(this.getName() + " cannot block %d impacts%s", impacts,
					(isAlive() ? "\n" : " and dies\n"));
		} else {
			System.out.printf("The hero %s blocks the attack\n", this.getName());
		}

		return wounds;
	}

	/**
	 * Get the name of the player controlling this hero
	 * 
	 * @return the name of the player
	 */
	public String getPlayerName() {
		return player;
	}

	/**
	 * Set the name of the player that controls this hero
	 * 
	 * @param playerName name of the player
	 */
	public void setPlayerName(String playerName) {
		this.player = playerName;
	}

	/**
	 * Check if the character given as argument is an enemy of the current one. An
	 * enemy will be all characters that are monsters (Overridden method)
	 * 
	 * @param c character to check
	 * @return true if it an enemy of the current character
	 */
	@Override
	public boolean isEnemy(Character c) {
		if(c instanceof Monster) {
			if(c instanceof Invisibility && ((Invisibility)c).isHidden()) {
				return false;
			}
		}
		return (c instanceof Monster);
	}

	/**
	 * Generate a printable version of the object as String, it adds to the
	 * description of the character the weapon that carries (Overridden method)
	 * 
	 * @return The printable version as String of the character
	 */
	@Override
	public String toString() {
		String s = super.toString();
		if (weapon != null)
			s += " Armed with " + weapon.toString();

		return s;
	}
}
