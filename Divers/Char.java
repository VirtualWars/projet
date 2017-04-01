package Divers;

import javax.swing.JOptionPane;

import Cellule.Coordonnee;
import Cellule.Robot;

public class Char extends Robot {
	private final static int POINTDEMOUVEMENT = 3;

	
	public Char(int equipe, int x, int y,Plateau p) {
		super(equipe, x, y,p, Char.POINTDEMOUVEMENT, 1, 5, 6, 0, 10,60, "C");
		
	}

	
	public String getType() {
		return "Char";
	}



	public void resetDeplacement() {
		super.setDeplacement(POINTDEMOUVEMENT);
		
	}
	
	public void deplacement(){
		Plateau plateau = this.getVue().getPlateau();
		String saisie = "";
		while(this.getDeplacement() > 0){
			
			Object[] possibleValues = { "Haut", "Bas", "Gauche","Droite","Haut gauche","Haut droite","Bas gauche","Bas droite","Arréter de se déplacer" };
			saisie = (String) JOptionPane.showInputDialog(null,
			"Quelle action veux tu effectuer ?\n Il reste " + this.getDeplacement() + " deplacement possible avec ce Robot." , "Choix actions pour " + this.getType() + " " +  this.getC(),
			JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues[0]);
			Coordonnee test = this.getC();
			if(this.getC().getY()+2 < plateau.getLargeur() && saisie.equals("Droite") && plateau.getPlat()[this.getC().getX()][this.getC().getY()+2].estHerbe() && 
					plateau.getPlat()[this.getC().getX()][this.getC().getY()+2].noRobot()){
				this.setCoordonnee(this.getC().getX(), this.getC().getY()+2);
			}else if(this.getC().getY()-2 >= 0 && saisie.equals("Gauche") && plateau.getPlat()[this.getC().getX()][this.getC().getY()-2].estHerbe()&& 
					plateau.getPlat()[this.getC().getX()][this.getC().getY()-2].noRobot()){
				this.setCoordonnee(this.getC().getX(), this.getC().getY()-2);
			}else if(this.getC().getX()+2 < plateau.getLongueur() && saisie.equals("Bas") && plateau.getPlat()[this.getC().getX()+2][this.getC().getY()].estHerbe() && 
					plateau.getPlat()[this.getC().getX()+2][this.getC().getY()].noRobot()){
				this.setCoordonnee(this.getC().getX()+2, this.getC().getY());
			}else if(this.getC().getX()-2 >= 0 && saisie.equals("Haut") && plateau.getPlat()[this.getC().getX()-2][this.getC().getY()].estHerbe() && 
					plateau.getPlat()[this.getC().getX()-2][this.getC().getY()].noRobot()){
				this.setCoordonnee(this.getC().getX()-2, this.getC().getY());
			}else if(saisie.equals("Arréter de se déplacer")){
				this.setDeplacement(-1);

			}
		
			
			this.setDeplacement(this.getDeplacement()-1);

			
			
			if((this.getC().getX()==0 && this.getC().getY()==1) || (this.getC().getX()==plateau.getLargeur()-1 && this.getC().getY()==plateau.getLongueur()-2)){
				this.setDeplacement(this.getDeplacement()+1);
			}
			
			this.getVue().setPlateau(plateau);

			if(!this.getC().equals(test)){
				this.setEnergie(this.getEnergie()-this.getCoutDeplc());
				
				System.out.println(this.getVue().getPlateau());
			}
			else{
				System.out.println(plateau);				
			}
			
		}
	}

}