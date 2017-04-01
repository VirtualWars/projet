package Divers;
//import java.util.List;

import Cellule.Robot;



public class Piegeur extends Robot{

	private final static int POINTDEMOUVEMENT = 10;
	
	/*public void setDeplcament(int deplacement){
		this.deplacement = deplacement;
	}*/

	public Piegeur(int equipe, int x, int y,Plateau p) {
		super(equipe, x, y,p,Piegeur.POINTDEMOUVEMENT,2,2,0,2,1,50,"P");
	}
	
	public boolean peutAttaquer(){
		return super.getEnergie() >= 2;
	}

	public boolean peutTirer() {
		return false;
	}

	


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Piegeur";
	}


	@Override
	public void resetDeplacement() {
		super.setDeplacement(POINTDEMOUVEMENT);
		
	}
	
}
