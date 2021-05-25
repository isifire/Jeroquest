package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.logic.Game;

public class Thief extends Goblin implements Invisibility{

	protected static final int DEFENCE = 2;
	private Bag bolsa;
	private boolean hidden = false;
	
	private static Icon icon2 =  new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/square.png"));

	
	public Bag getBolsa() {
		return bolsa;
	}

	public void setBolsa(Bag bolsa) {
		this.bolsa = bolsa;
	}

	public Thief(String name) {
		super(name);
		this.setDefence(DEFENCE);
		this.setDefenceInitial(DEFENCE);
		bolsa = new Bag();
	}
	
	public boolean isHidden() {
		return this.hidden;
	}
	
	public void show() {
		this.hidden = false;
	}
	
	public void hide(Game pa) {
		switch(Dice.roll(2)) {
		case 1:
			this.hidden = true;
			break;
		case 2:
			break;
		}
	}
	
	@Override
	public Icon getImage() {
		if(this.isHidden()) {
			 return icon2;
		}
		else {
			return super.getImage();	
		}
		
	}
	
	
	@Override
	public void resolveTurn(Game currentGame) {
		if(!this.isHidden()) {
			this.hide(currentGame);
		}
		super.resolveTurn(currentGame);
	}

	@Override
	public void combat(Character c, Game currentGame) { // attacks to c and c defends itself
		if(c instanceof Hero && this.isHidden() && ((Hero)c).getWeapon() != null) {
			this.getBolsa().save(((Hero)c).getWeapon());
			((Hero)c).setWeapon(null);
			this.show();
		}
		else {
			super.combat(c, currentGame);
		}
	}
	
}
