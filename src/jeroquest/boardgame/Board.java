package jeroquest.boardgame;

/**
 * Programming Methodology Practice. Jeroquest - An example of Object Oriented
 * Programming. Class Board - class that represents the game board
 * 
 * @author Jorge Puente Peinador y Ramiro Varela Arias
 * @author Juan Luis Mateo
 *
 */

public class Board {
	private Square[][] squares; // squares matrix
	private int rows; // number of rows
	private int columns; // number of columns

	/**
	 * Create a board according to the specified dimensions (constructor)
	 * 
	 * @param rows    the number of rows in the board
	 * @param columns the number of columns in the board
	 */
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		squares = new Square[rows][columns];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < columns; j++)
				squares[i][j] = new Square();
	}

	/**
	 * Get the number of rows in the board
	 * 
	 * @return the number of rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Get the number of columns in the board
	 * 
	 * @return the number of columns
	 */
	public int getColumns() {
		return columns;
	}

	/**
	 * Get the square for a given position in the board
	 * 
	 * @param pos position in the board
	 * @return the square for that position
	 */
	private Square getSquare(XYLocation pos) {
		return squares[pos.getX()][pos.getY()];
	}

	/**
	 * Takes a piece out of the board
	 * 
	 * @param p piece to take out of the board
	 */
	public void removePiece(Piece p) {
		// if the character is in the board
		if (p.getPosition() != null) {
			// it is taken out
			getSquare(p.getPosition()).setPiece(null);
			p.setPosition(null);
		}
	}

	/**
	 * Place a piece in a square adjacent to the current one (overloaded method)
	 * 
	 * @param p   the piece to place
	 * @param dir direction of movement: North, South, East or West
	 * @return true if it could be placed, false if it wasn't in the board, if the
	 *         square was already occupied or if it goes out of the board
	 */
	public boolean movePiece(Piece p, Direction dir) {
		XYLocation pos1 = p.getPosition();
		if (pos1 == null) // if it wasn't in the board it cannot be moved
			return false;

		XYLocation pos2 = null;
		// get the square in that direction
		switch (dir) {
		case North:
			pos2 = pos1.north();
			break;
		case South:
			pos2 = pos1.south();
			break;
		case East:
			pos2 = pos1.east();
			break;
		case West:
			pos2 = pos1.west();
			break;
		}
		// move the character checking that the square is valid in that direction
		return movePiece(p, pos2); // trying to move to that square
	}

	/**
	 * Checks if the square is valid
	 * 
	 * @param pos position to check
	 * @return true if the square is valid
	 */
	private boolean validSquare(XYLocation pos) {
		// if the square is not valid
		if ((pos.getX() < 0) || (pos.getX() >= rows))
			return false;
		if ((pos.getY() < 0) || (pos.getY() >= columns))
			return false;
		// otherwise it is valid
		return true;
	}

	/**
	 * Checks if a square is valid and it is free
	 * 
	 * @param pos position to check
	 * @return true if the square is free
	 */
	public boolean freeSquare(XYLocation pos) {
		return validSquare(pos) && getSquare(pos).empty();
	}

	/**
	 * Place a piece in an empty square (overloaded method)
	 * 
	 * @param p   piece to place
	 * @param pos square position
	 * @return true it the placement could be made, false if the square was occupied
	 *         or it wan't valid
	 */
	public boolean movePiece(Piece p, XYLocation pos) {
		if (freeSquare(pos)) {
			// remove the piece from the current square
			removePiece(p);
			// set the piece to the new square
			p.setPosition(pos);
			getSquare(pos).setPiece(p);

			return true; // it could be moved
		} else
			return false; // it couldn't be moved
	}

	/**
	 * Generate a printable representation of the object (overridden method)
	 * 
	 * @return the printable representation of the board
	 */
	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				s += squares[i][j];
			s += "\n";
			;
		}
		return s;
	}

}
