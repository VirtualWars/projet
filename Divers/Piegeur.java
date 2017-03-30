package Divers;
//import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cellule.Coordonnee;
//import Cellule.Coordonnee;
import Cellule.Robot;

public class Piegeur extends Robot{


	
	/*public void setDeplcament(int deplacement){
		this.deplacement = deplacement;
	}*/

	public Piegeur(int equipe, int x, int y) {
		super(equipe, x, y,1,2,2,0,2,1,"P");
	}
	
	public boolean peutAttaquer(){
		return super.getEnergie() >= 2;
	}

	public boolean peutTirer() {
		return false;
	}

	
	/*private boolean testSaisieCorrect(String s){
		if (s.length() != 5) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if(i != 2){
				if (!(s.charAt(i)>='0' && s.charAt(i)<='9')) {
					return false;
				}
			}else{
				if(s.charAt(i)!='/'){
					return false;
				}
			}
		}
		return true;
	}*/

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Piegeur";
	}

	@Override
	public boolean bonSensAttaque(Coordonnee c) {
		// TODO Auto-generated method stub
		return false;
	}
}
