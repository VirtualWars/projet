package Cellule;

public class Rocher extends Cellule{

	@Override
	public boolean estHerbe() {
		return false;
	}

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
		return "R";
	}
		
}
