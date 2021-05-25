package jeroquest.boardgame;
/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class Square - class that represents each one of the squares in
 * the board
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

public class Square {
	private Piece piece; // character that is in this square

	/**
	 * Constructor for an empty square (without a character)
	 */
	public Square() {
		piece = null;
	}

	/**
	 * Get the piece in this square
	 * 
	 * @return the piece in this square, or null if there isn't any
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * Set the piece in the square
	 * 
	 * @param piece the piece that is placed in the square
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * Checks if the square has a piece in it
	 * 
	 * @return true if it doesn't a piece
	 */
	public boolean empty() {
		return piece == null;
	}

	/**
	 * Generate a printable version of the object as String (Overridden method)
	 * 
	 * @return The printable version of the square as String
	 */
	@Override
	public String toString() {
		if (piece == null)
			return "-";
		else
			return String.format("%c", piece.toChar());
	}
}
