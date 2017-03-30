package Divers;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cellule.Cellule;
import Cellule.Coordonnee;
import Cellule.Robot;

public class Tireur extends Robot{

	public Tireur(int equipe, int x, int y){
		super(equipe,x,y,1,2,1,3,0,3,"T");
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





















}