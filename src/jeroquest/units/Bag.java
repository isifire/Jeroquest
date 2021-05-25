package jeroquest.units;

import jeroquest.boardgame.Dice;

public class Bag {

	private final int capacidad = Dice.roll(3)+2;
	private Weapon [] weapon;
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public Bag() {
		weapon = new Weapon[capacidad];
		for(int i = 0; i < weapon.length; i++) {
			weapon[i] = null;
		}
	}
	
	public boolean isFull() {
		for(int i = 0; i < this.weapon.length; i++) {
			if(weapon[i] == null) {
				return false;
			}
		}
		return true;
	}
	
	public void save(Weapon a) {
		for(int i = 0; i < weapon.length && weapon[i] != null; i++) {
			if(weapon[i] == null) {
				weapon[i] = a;
			}
		}
	}
	
	public Weapon[] getItems() {
		Weapon [] temp = this.weapon;
		return this.weapon;
	}
	
	@Override
	public String toString() {
		String cadena = "[ "; 
		for(int i = 0; i < weapon.length; i++) {
			if(weapon[i] == null) {
				cadena = cadena + "- ";
			}
			else {
				cadena = cadena + weapon[i];
			}
			if(i < weapon.length-1) {
				cadena = cadena + ", ";
			}
		}
		cadena = cadena + " ]";
		return cadena;
	}
	
}
