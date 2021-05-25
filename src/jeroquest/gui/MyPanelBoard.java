package jeroquest.gui;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import jeroquest.logic.Game;
import jeroquest.units.Character;

/**
 * Class MyPanelBoard, represents a panel with the elements of the current game:
 * the board, the characters and the current round
 * 
 * @author Programming Methodology Professors
 *
 */
public class MyPanelBoard extends JLayeredPane {
	// this avoids a warning referred to serialisable windows
	private static final long serialVersionUID = 1L;

	private Game theGame = null; // game to show

	// icons of the board elements
	Icon square = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/square.png"));

	// Label with the current round
	JLabel currentRoundJLabel = null;

	/**
	 * Panel constructor with the characters and the board
	 * 
	 * @param g the game
	 */
	public MyPanelBoard(Game g) {
		this.theGame = g;
		initializeBoard(g.getBoard().getRows(), g.getBoard().getColumns());
	}

	/**
	 * Create the graphical representation of the board in the panel
	 * 
	 * @param rows    number of rows in the board
	 * @param columns number of columns in the board
	 */
	private void initializeBoard(int rows, int columns) {
		// create the matrix of squares
		setPreferredSize(new Dimension(32 * (1 + columns), 32 * (1 + 1 + rows)));

		// create the labels for the coordinates
		for (Integer x = 0; x < columns; x++) {
			JLabel label = new JLabel(x.toString());
			label.setBounds(16 + x * 32, rows * 32, 32, 32);
			add(label, Integer.valueOf(1));
		}
		for (Integer x = 0; x < rows; x++) {
			JLabel label = new JLabel(x.toString());
			label.setBounds(16 + columns * 32, x * 32, 32, 32);
			add(label, Integer.valueOf(1));
		}

		// create a grid with the size of the board filling each square
		for (int x = 0; x < rows; x++)
			for (int y = 0; y < columns; y++) {
				// label with the image of an empty square
				JLabel c = new JLabel(square);
				// dimensions (32x32), position (X,Y)
				c.setBounds(y * 32, x * 32, 32, 32);
				// show the icon in its position
				add(c, Integer.valueOf(1));
			}

		// create the label with the current round
		currentRoundJLabel = new JLabel(
				"Round: " + this.theGame.getCurrentRound() + "/" + this.theGame.getTotalRounds());
		currentRoundJLabel.setBounds(16, (rows + 1) * 32, 128, 32);
		add(currentRoundJLabel, Integer.valueOf(1));
	}

	/**
	 * Convert the char \n of a String to <br>
	 * in HTML to make that the tooltip of a JLabel can be visualised correctly
	 * 
	 * @param orig string to format
	 * @return a formatted String as HTML
	 */
	public static String convertToMultiline(String orig) {
		return "<html>" + orig.replaceAll("\n", "<br>") + "</html>";
	}

	/**
	 * Show all characters in the board as icons, where their "tool tip" is the
	 * information of the method toString() of each object
	 */
	protected void showCharacters() {
		// show the current round
		currentRoundJLabel.setText("Round: " + this.theGame.getCurrentRound() + "/" + this.theGame.getTotalRounds());
		// delete labels for previous characters
		for (Component comp : getComponents())
			if (getLayer(comp) == 2) // if it is in the layer 2, then it is the icon of a character
				this.remove(comp);

		// recreate the characters
		for (Character cj : theGame.getCharacters())
			cj.show(this);

		// If is is necessary to show anything else in the board, the code will be here
		// using the information of the object "theGame"

		// update its container what will refresh the screen
		validate();
		repaint();
	}
}
