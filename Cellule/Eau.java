package Cellule;

public class Eau extends Cellule{

	@Override
	public boolean estHerbe() {
		return false;
	}

	@Override
	public boolean estObstacle() {
		return true;
	}


	@Override
	public int contientMine() {
		return 0;
	}

	@Override
	public int estBase() {
		return 0;
	}
	public String getRepresentation(){
		return "~";
				
	}
	
	public static String getRouge() {
	    return "\033[31m";
	}
}
