package Divers;

import Cellule.Coordonnee;
import Cellule.Robot;

public class Tireur extends Robot{

	private final static int POINTDEMOUVEMENT = 5;
    /**
	 * crée un robot de type tireur
	 * @param equipe
	 * @param x = coordonnee
	 * @param y = coordonnee
	 */
	public Tireur(int equipe, int x, int y,Plateau p){
		super(equipe,x,y,p,Tireur.POINTDEMOUVEMENT,2,1,3,0,3,40,"T");
	}
	
	
    /**
     * verifie si l'attaque est possible avec les coordonnee fournis
     * @param c
     * @return la validité
     */
	public boolean bonSensAttaque(Coordonnee c){
		if(this.getC().getX()==c.getX() && this.getC().getY()-c.getY() <= this.getPortee()){
			return true;
		}
		if(this.getC().getY()==c.getY() && this.getC().getX()-c.getX() <= this.getPortee()){
			return true;
		}
		return false;
		
	}

    /**
     * Renvoir le type du robot 
     * @return type du robot
     */
	public String getType() {
		// TODO Auto-generated method stub
		return "Tireur";
	}



	@Override
	public void resetDeplacement() {
		super.setDeplacement(POINTDEMOUVEMENT);
	}



	

}