package Cellule;


public class Cellule {
		
	Robot r = null;
	private int mine = 0;

	private int equipe;  //0) tout le monde peut posséder cette case, 1) equipe 1,2) equipe 2
    /**
	* Retourne vrai si la cellule est un herbe
	*/
	public boolean estHerbe(){
		return true;
	}
    /**
	* Retourne vrai si la cellule contient une mine
	*/
	public int contientMine(){
		return mine;
	}
    /**
	* Retourne vrai si la cellule est une base
	*/
	public int estBase(){
		return 0;
	}
    /**
	* Retourne le robot si un robot est situé sur la cellule
	*/

	public Robot getR() {
		return r;
	}
    /**
	* Retourne la représentation du contenu de la cellule
	*/
	public String getRepresentation() {
		if (r == null) {
			return " ";
		} else {
			return r.getRepresentation();
		}
	}
    /**
	* Retourne vrai si la cellule est un obstacle
	*/
	public boolean estObstacle() {
		return false;
	}
    /**
	* Rajoute u  robot sur la case
	* @param Robot à placer sur la case
	*/
	public void setRobot(Robot r){
		this.r = r;
	}

	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
    /**
	* Retourne vrai si la cellule n'a pas de robot
	*/
	public boolean noRobot(){
		return r==null;
	}
	//---

}