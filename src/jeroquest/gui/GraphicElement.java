package jeroquest.gui;

import javax.swing.Icon;

public interface GraphicElement {
	/**
	 * Return the icon image associated to a grphic element
	 * 
	 * @return the associated icon to the graphic element
	 */
	Icon getImage();

	/**
	 * Show a icon representing the character as an icon in the layer 2
	 * 
	 * @param w graphic panel where to show the icon
	 */
	void show(MyPanelBoard w);
}
