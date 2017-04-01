package Cellule;
//import java.util.List;

import javax.swing.JOptionPane;

import Divers.*;

public abstract class Robot {

		private int equipe;
		private int energie;
		private Coordonnee c;
		private  int deplacement;
		private  int coutAction;
		private  int coutDeplc;
		private  int degatTir;
		private  int degatMine;
		private  int portee;
		private  String representation = "R";
		private Vue v;
		
		
		//public Robot(int equipe, Vue vue, int x, int y){  quand les vue seront faite mettre ce constructeur
		public Robot(int equipe, int x, int y,Plateau p,int deplacement,int coutAction,int coutDeplc,int degatTir,int degatMine,int portee,int energie,String representation){
			
			this.equipe = equipe;
			this.c = new Coordonnee(x,y);
			this.deplacement=deplacement;
			this.coutAction=coutAction;
			this.coutDeplc=coutDeplc;
			this.degatTir=degatTir;
			this.degatMine=degatMine;
			this.representation=representation;
			this.portee=portee;
			this.energie=energie;
			this.v=new Vue(p,equipe);
		
		}
		public int getDeplacement() {
			return deplacement;
		}
		
		public int getCoutAction() {
			return coutAction;
		}
		public int getDegatTir() {
			return degatTir;
		}
		public int getDegatMine() {
			return degatMine;
		}
		public String getRepresentation(){
			if(this.equipe == 1){
				return representation;
			}
			return representation.toLowerCase();
		}
		public Coordonnee getC() {
			return c;
		}
		public  int getCoutDeplc() {
			return coutDeplc;
		}
		public int getX(){
			return c.getX();
		}
		public int getY(){
			return c.getY();
		}
		public int getEquipe() {
			return equipe;
		}
		
		public int getPortee(){
			return portee;
		}
		public Vue getVue(){
			return v;
		}
		public void setCoordonnee(int x , int y){
			c = new Coordonnee(x,y);
		}
		public void setEquipe(int equipe) {
			this.equipe = equipe;
		}
		public int getEnergie() {
			return energie;
		}
		public void setEnergie(int energie) {
			this.energie = energie;
		}
		public void subitTir(int degatTir){
			energie -= degatTir;
		}
		public void subitMine(){
			energie -=5;
		}
		public String toString() {
			return "Robot [equipe=" + equipe + ", energie=" + energie + ", c=" + c + "]";
		}
		public boolean peutTirer(){
			return this.getEnergie()>this.getCoutAction();

		}
		public void setDeplacement(int x){
			this.deplacement = x;
		}
		

		
	
		public abstract String getType();
		public abstract void resetDeplacement();



		
		public void deplacement(){
			Plateau plateau = this.v.getPlateau();
			String saisie = "";
			while(this.getDeplacement() > 0){
				
				Object[] possibleValues = { "Haut", "Bas", "Gauche","Droite","Haut gauche","Haut droite","Bas gauche","Bas droite","Arréter de se déplacer" };
				saisie = (String) JOptionPane.showInputDialog(null,
				"Quelle action veux tu effectuer ?\n Il reste " + this.getDeplacement() + " deplacement possible avec ce Robot." , "Choix actions pour " + this.getType() + " " +  this.getC(),
				JOptionPane.INFORMATION_MESSAGE, null,
				possibleValues, possibleValues[0]);
				Coordonnee test = this.getC();
				if(this.c.getY()+1 < plateau.getLargeur() && saisie.equals("Droite") && plateau.getPlat()[this.c.getX()][this.c.getY()+1].estHerbe() && 
						plateau.getPlat()[this.getC().getX()][this.getC().getY()+1].noRobot()){
					this.setCoordonnee(this.c.getX(), this.c.getY()+1);
				}else if(this.c.getY()-1 >= 0 && saisie.equals("Gauche") && plateau.getPlat()[this.c.getX()][this.c.getY()-1].estHerbe() && 
						plateau.getPlat()[this.getC().getX()][this.getC().getY()-1].noRobot()){
					this.setCoordonnee(this.c.getX(), this.c.getY()-1);
				}else if(this.c.getX()+1 < plateau.getLongueur() && saisie.equals("Bas") && plateau.getPlat()[this.c.getX()+1][this.c.getY()].estHerbe() && 
						plateau.getPlat()[this.getC().getX()+1][this.getC().getY()].noRobot()){
					this.setCoordonnee(this.c.getX()+1, this.c.getY());
				}else if(this.c.getX()-1 >= 0 && saisie.equals("Haut") && plateau.getPlat()[this.c.getX()-1][this.c.getY()].estHerbe() && 
						plateau.getPlat()[this.getC().getX()-1][this.getC().getY()].noRobot()){
					this.setCoordonnee(this.c.getX()-1, this.c.getY());
				}else if(saisie.equals("Arréter de se déplacer")){
					this.setDeplacement(-1);

				}
				else if(this.c.getY()-1 >= 0 && this.c.getX()-1>=0 && saisie.equals("Haut gauche") && plateau.getPlat()[this.c.getX()-1][this.c.getY()-1].estHerbe()  && 
						plateau.getPlat()[this.getC().getX()-1][this.getC().getY()-1].noRobot()){
					this.setCoordonnee(this.c.getX()-1, this.c.getY()-1);
				}
				else if(this.c.getY()-1 >= 0 && this.c.getX()+1>=0 && saisie.equals("Bas gauche") && plateau.getPlat()[this.c.getX()+1][this.c.getY()-1].estHerbe() && 
						plateau.getPlat()[this.getC().getX()+1][this.getC().getY()-1].noRobot()){
					this.setCoordonnee(this.c.getX()+1, this.c.getY()-1);
				}
				else if(this.c.getY()+1 >= 0 && this.c.getX()-1>=0 && saisie.equals("Haut droite") && plateau.getPlat()[this.c.getX()-1][this.c.getY()+1].estHerbe() && 
						plateau.getPlat()[this.getC().getX()-1][this.getC().getY()+1].noRobot()){
					this.setCoordonnee(this.c.getX()-1, this.c.getY()+1);
				}
				else if(this.c.getY()+1 >= 0 && this.c.getX()+1>=0 && saisie.equals("Bas droite") && plateau.getPlat()[this.c.getX()+1][this.c.getY()+1].estHerbe() && 
						plateau.getPlat()[this.getC().getX()+1][this.getC().getY()+1].noRobot()){
					this.setCoordonnee(this.c.getX()+1, this.c.getY()+1);
				}
				
				
				this.setDeplacement(this.getDeplacement()-1);

				
				
				if((this.getC().getX()==0 && this.getC().getY()==1) || (this.getC().getX()==plateau.getLargeur()-1 && this.getC().getY()==plateau.getLongueur()-2)){
					this.setDeplacement(this.getDeplacement()+1);
				}

				v.setPlateau(plateau);
				
				if(!this.getC().equals(test)){
					this.setEnergie(this.getEnergie()-this.getCoutDeplc());
					
					System.out.println(v.getPlateau());
				}
				else{
					System.out.println(plateau);				
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

