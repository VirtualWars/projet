package Divers;

import Cellule.Coordonnee;
import Cellule.Robot;

public class Tireur extends Robot{

	private final static int POINTDEMOUVEMENT = 5;
	
	public Tireur(int equipe, int x, int y,Plateau p){
		super(equipe,x,y,p,Tireur.POINTDEMOUVEMENT,2,1,3,0,3,40,"T");
	}
	
	

	public boolean bonSensAttaque(Coordonnee c){
		if(this.getC().getX()==c.getX() && this.getC().getY()-c.getY() <= this.getPortee()){
			return true;
		}
		if(this.getC().getY()==c.getY() && this.getC().getX()-c.getX() <= this.getPortee()){
			return true;
		}
		return false;
		
	}


	public String getType() {
		// TODO Auto-generated method stub
		return "Tireur";
	}



	@Override
	public void resetDeplacement() {
		super.setDeplacement(POINTDEMOUVEMENT);
	}



	

}