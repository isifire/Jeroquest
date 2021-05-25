package jeroquest.units;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Clasw Weapon - class that represents the heroes' weapons
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

public class Weapon {

	private String name; // name del arma
	private int attack; // dados de attack del arma

	/**
	 * Constructor of Weapon from it components
	 * 
	 * @param name   the name of the weapon
	 * @param attack dices of damage for the weapon
	 */
	public Weapon(String name, int attack) {
		this.name = name;
		this.attack = attack;
	}

	/**
	 * Getter for name
	 * 
	 * @return name of the weapon
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for attack
	 * 
	 * @return attack dices for the weapon
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Generate a printable version of the object as String (Overridden method)
	 * 
	 * @return printable version of the weapon as String
	 */
	@Override
	public String toString() {
		return name + " (" + attack + " dices)";
	}
}
