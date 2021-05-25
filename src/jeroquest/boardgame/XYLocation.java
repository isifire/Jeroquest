package jeroquest.boardgame;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class XYLocation - class that represents positions in a 2D board
 * 
 * @author Jorge Puente Peinador y Ramiro Varethe Arias
 * @author Juan Luis Mateo
 *
 */

public class XYLocation {

	private int x, y; // 2D coordinates

	/**
	 * Create a location from its coordinates
	 * 
	 * @param x the row
	 * @param y the column
	 */
	public XYLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Get the coordinate x
	 * 
	 * @return the coordinate x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the coordinate y
	 * 
	 * @return the coordinate y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set the coordinate x
	 * 
	 * @param x the new coordinate x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Set the coordinate y
	 * 
	 * @param y the new coordinate y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Get the position immediately to the North from the current one
	 * 
	 * @return the position to the north from the current
	 */
	public XYLocation north() {
		return new XYLocation(this.x - 1, this.y);
	}

	/**
	 * Get the position immediately to the South from the current one
	 * 
	 * @return the position to the south from the current
	 */
	public XYLocation south() {
		return new XYLocation(this.x + 1, this.y);
	}

	/**
	 * Get the position immediately to the East from the current one
	 * 
	 * @return the position to the east from the current
	 */
	public XYLocation east() {
		return new XYLocation(this.x, this.y + 1);
	}

	/**
	 * Get the position immediately to the West from the current one
	 * 
	 * @return the position to the west from the current
	 */
	public XYLocation west() {
		return new XYLocation(this.x, this.y - 1);
	}

	/**
	 * Operation to check if two objects XYLocation are the same
	 * 
	 * @param o object to compare to
	 * @return true if the object XYLocation has the same coordinates
	 */
	@Override
	public boolean equals(Object o) {
		if (null == o || !(o instanceof XYLocation)) {
			return super.equals(o);
		}
		XYLocation anotherLoc = (XYLocation) o;
		return ((anotherLoc.getX() == x) && (anotherLoc.getY() == y));
	}

	/**
	 * Generate a printable version of the object as a String (overridden method)
	 * 
	 * @return The printable version as String of the object
	 */
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}