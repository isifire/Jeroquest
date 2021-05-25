package jeroquest.units;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jeroquest.boardgame.Dice;
import jeroquest.logic.Game;
import jeroquest.utils.DynamicVectorCharacters;


public class Zombie extends Monster{

	protected static final int MOVEMENT = 4;
	protected static final int ATTACK = 3;
	protected static final int DEFENCE = 0;
	protected static final int BODY = 3;
	
	public Zombie(String name) {
		super(name,MOVEMENT,ATTACK,DEFENCE,BODY);
	}
	
	
	@Override
	public int defend(int impacts) {
		return super.defend(0);
	}
	
	@Override
	public boolean actionCombat(Game currentGame) {

		DynamicVectorCharacters targets = validTargets(currentGame);

		if (targets.length() > 0) {
			Character target = null;
			for(int i = 0; i < targets.length() && target == null; i++) {
				if(targets.get(i) instanceof Barbarian) {
					target = targets.get(i);
				}
			}
			
			if(target == null) {
				target = targets.get(Dice.roll(targets.length()) - 1);
			}


			System.out.println(
					this.getName() + this.getPosition() + " attacks to " + target.getName() + target.getPosition());
			this.combat(target, currentGame);
			return true;
		}
		return false;
	}
	
	
	public void degradacion() {
		if(this.isAlive()) {
			this.setBody(this.getBody()-1);
		}
	}
	
	public char toChar() {
		return 'Z';
	}
	
	private static Icon icon = new ImageIcon(ClassLoader.getSystemResource("jeroquest/gui/images/zombi.gif"));

	public Icon getImage() {
		return icon;
	}
	
}
