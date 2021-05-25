package jeroquest.utils;

import jeroquest.boardgame.XYLocation;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class DynamicVectorXYLocation - Class that allows to represent
 * dynamic vector of XYLocation
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */
public class DynamicVectorXYLocation extends DynamicVectorObjects {

	public DynamicVectorXYLocation() {

	}

	public DynamicVectorXYLocation(DynamicVectorXYLocation vDE) {
		super(vDE);
	}

	public DynamicVectorXYLocation(int size) {
		super(size);
	}

	public DynamicVectorXYLocation(Integer[] v) {
		super((Object[]) v);
	}

	@Override
	public XYLocation get(int i) {
		return (XYLocation) super.get(i);
	}

	// Other methods
	@Override
	public XYLocation[] vectorNormal() { // return a XYLocation[] as the integer of vOI
		XYLocation[] temp = new XYLocation[this.length()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = this.get(i);
		return temp;
	}

}
