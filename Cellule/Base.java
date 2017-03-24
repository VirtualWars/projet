package Cellule;

public class Base extends Cellule{

	private int equipe;
	
	public Base(int equipe){
		this.equipe = equipe;
	}

	public boolean estHerbe() {
		return false;
	}
	public boolean estRocher() {
		return false;
	}
	public boolean estArbre() {
		return false;
	}
	public boolean estEau() {
		return false;
	}
	public int contientMine() {
		return 0;
	}
	public int estBase() {
		return equipe;
	}
	public char getRepresentation(){
		return 'B';
	}
	
	
}
