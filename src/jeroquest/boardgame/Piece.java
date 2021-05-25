package jeroquest.boardgame;
/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Interface Piece - interface that models the behaviour of a piece
 * in the board
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

public interface Piece {

	/**
	 * Get the position in the board
	 * 
	 * @return the position in the board
	 */
	XYLocation getPosition();

	/**
	 * Set the position of the piece in the board
	 * 
	 * @param pos new position of the piece in the board
	 */
	void setPosition(XYLocation pos);

	/**
	 * Return a char tha represents the piece
	 * 
	 * @return the char representation fo the piece
	 */
	char toChar();

}
