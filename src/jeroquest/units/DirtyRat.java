package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.boardgame.XYLocation;
import jeroquest.gui.MyKeyboard;
import jeroquest.logic.Game;
import jeroquest.logic.Jeroquest;
import jeroquest.utils.DynamicVectorCharacters;
import jeroquest.utils.DynamicVectorXYLocation;

public class DirtyRat extends Monster {

	protected static final int MOVEMENT = 4;
	protected static final int ATTACK = 2;
	protected static final int DEFENCE = 2;
	protected static final int BODY = 5;
	protected boolean fearful = false;
	
	public boolean isFearful() {
		return fearful;
	}

	public void setFearful(boolean fearful) {
		this.fearful = fearful;
		this.icon = this.getImage();
	}

	public DirtyRat(String name) {
		super(name,MOVEMENT,ATTACK,DEFENCE,BODY);
		this.fearful = false;
	}
	
	public char toChar() {
		return 'R';
	}
	
	private Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/rata.png"));
	private static Icon iconNormal = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/rata.png"));
	private static Icon iconFear = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/rata_asustada.png"));

	
	
	public Icon getImage() {
		if(this.isFearful()) {
			return iconFear;
		}
		else {
			return iconNormal;
		}
	}
	
	@Override
	public boolean isEnemy(Character c) {
		return(this.getBody() > c.getBody());
	}
	
	@Override
	public int defend(int impacts) {
		int wounds = 0;

		for (int totalDefenceDices = getDefence(); (impacts > 0) && (totalDefenceDices > 0); totalDefenceDices--)
			if (Dice.roll() == 6) // a 6 is necessary to block an impact
				impacts--;

		// if any unblocked impact, decrement body points
		if (impacts > 0) {
			
			// the life of a character cannot be lower then zero
			wounds = Math.min(getBody(), impacts);
			setBody(getBody() - wounds);
			if(this.isFearful() == true && this.getBody() < this.getBodyInitial()/2) {
				this.setBody(0);
			}
			this.setFearful(true);
			System.out.printf("The monster " + this.getName() + " cannot block %d impacts%s", impacts,
					(isAlive() ? "\n" : " and dies\n"));
		} else {
			System.out.printf("The monster %s blocks the attack\n", this.getName());
			this.setFearful(false);
		}

		return wounds;
	}
	
	
	
	@Override
	public int actionMovement(Game currentGame) {
		if(!this.isFearful()) {
			return super.actionMovement(currentGame);
		}
		else {
			return 0;
		}

	}
	
	@Override
	public boolean actionCombat(Game currentGame) {
		if(!this.isFearful()) {
			return super.actionCombat(currentGame);
		}
		else {
			return false;
		}
	}
	
	public void regenerate() {
		if(!(this.isFearful()) && (this.getBody() < this.getBodyInitial())){
			this.setBody(this.getBody()+1);
		}
		if(this.isFearful()) {
			this.setFearful(false);
		}
	}
	
	
}
