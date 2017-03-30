package Divers;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cellule.Cellule;
import Cellule.Coordonnee;
import Cellule.Robot;

public class Tireur extends Robot{

	public Tireur(int equipe, int x, int y,Cellule[][] plat){
		super(equipe,x,y,1,2,1,3,0,3,"T",plat);
	}
	
	/*public void setDeplcament(int deplacement){
		this.deplacement = deplacement;
	}
	public int getDeplacement() {
		return deplacement;
	}
	public int getCoutAction() {
		return coutAction;
	}
	public int getCoutDeplacement() {
		return coutDeplc;
	}
	public int getDegatTir() {
		return degatTir;
	}
	public int getDegatMine() {
		return degatMine;
	}
	public String getType(){
		return "tireur";
	}
	public Tireur(int equipe, int x, int y) {
		super(equipe, x, y);
	}
	
	public boolean peutTirer(){
		return super.getEnergie() >= 2;
	}

	public List<Coordonnee> getDeplacements() {
		
		return null;
	}
	public String getRepresentation() {
		return representation;
	}*/
	

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





















}