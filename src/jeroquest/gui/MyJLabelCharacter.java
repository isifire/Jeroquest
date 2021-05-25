package jeroquest.gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import jeroquest.boardgame.XYLocation;
import jeroquest.units.Character;

/**
 * Class MyJLabelCharacter, models a graphical label of Java with a character
 * associated to it Having the character allows it to show the "life bar" over
 * the icon
 * 
 * @author Programming Methodology Professors
 *
 */
public class MyJLabelCharacter extends JLabel {
	// this avoids a warning referred to serialisable windows
	private static final long serialVersionUID = 1L;

	private Character cj;

	/**
	 * Constructor to create the icon of a character in the board
	 * 
	 * @param cj character to show
	 */
	public MyJLabelCharacter(Character cj) {
		// associate the icon of the character with the JLabel
		super(((GraphicElement) cj).getImage());
		this.cj = cj;

		// size 32x32 and placed in its position (X,Y)
		XYLocation pos = cj.getPosition();
		setBounds(pos.getY() * 32, pos.getX() * 32, 32, 32);
		// set as tooltip the description of the character
		setToolTipText(MyPanelBoard.convertToMultiline(cj.toString()));
	}

	/**
	 * Create a bar showing the current life of the character The colour indicate
	 * the current value with respect to the initial one (the maximum)
	 * 
	 * @param g            Graphics object to paint over
	 * @param currentValue current life
	 * @param maximum      initial life
	 */
	private void lifeBar(Graphics g, int currentValue, int maximum) {
		// scaling so that the maximum fits in 32 pixels
		int width = (int) Math.round(currentValue * 32 / maximum);

		// bar white frame
		g.setColor(Color.WHITE);
		g.drawRect(0, 28, 31, 3);

		// bar black background
		g.setColor(Color.BLACK);
		g.fillRect(1, 29, 30, 2);

		// set the colour of the bar...
		// GREEN: if it has more than 75% of life
		if (cj.getBody() > 0.75 * cj.getBodyInitial())
			g.setColor(Color.GREEN);
		// YELLOW: if it has between (50%..75%] of life
		else if (cj.getBody() > 0.5 * cj.getBodyInitial())
			g.setColor(Color.YELLOW);
		// RED: if the life is <= 50%
		else
			g.setColor(Color.RED);
		// Draw the bar
		g.fillRect(1, 29, width - 2, 2);

	}

	/**
	 * Paint the character in its position and over the icon the bar of life
	 * 
	 * @param g Graphics object where to paint
	 */
	@Override
	public void paintComponent(Graphics g) {

		// the method of JLabel will show the icon of the character
		super.paintComponent(g);

		// paint over the icon the bar of life
		lifeBar(g, cj.getBody(), cj.getBodyInitial());
	}
}
