package Cellule;


public class Cellule {
		
	Robot r = null;
	private int mine = 0;

	private int equipe;  //0) tout le monde peut posséder cette case, 1) equipe 1,2) equipe 2

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
	public String getRepresentation() {
		if (r == null) {
			return " ";
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
	
	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	//---

}