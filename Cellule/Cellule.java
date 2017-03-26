package Cellule;


public class Cellule {
		
	Robot r = null;
	private int mine = 0;

	public boolean estHerbe(){
		return true;
	}

	public int contientMine(){
		return mine;
	}
	public int estBase(){
		return 0;
	}
	

	public Robot getR() {
		return r;
	}
	public char getRepresentation() {
		if (r == null) {
			return ' ';
		} else {
			return r.getRepresentation();
		}
	}
	
	public boolean estObstacle() {
		return false;
	}
	//---
	public void setRobot(Robot r){
		this.r = r;
	}
	//---

}