package jeroquest.utils;
import jeroquest.units.Character;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class DynamicVectorCharacters - Class that allows to represent
 * dynamic vectors of Character
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

public class DynamicVectorCharacters extends DynamicVectorObjects {

	public DynamicVectorCharacters() {

	}

	public DynamicVectorCharacters(DynamicVectorCharacters vDE) {
		super(vDE);
	}

	public DynamicVectorCharacters(int size) {
		super(size);
	}

	public DynamicVectorCharacters(Character[] v) {
		super((Object[]) v);
	}

	@Override
	public Character get(int i) {
		return (Character) super.get(i);
	}

	// Other methods
	@Override
	public Character[] vectorNormal() { // returns a Character[] as the integers of vOI
		Character[] temp = new Character[this.length()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}

}
