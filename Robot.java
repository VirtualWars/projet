package Cellule;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Divers.Joueur;
import Divers.Vue;

public abstract class Robot {

		private int equipe;
		private int energie;
		private Vue vue;
		private Coordonnee c;
		
		
		//public Robot(int equipe, Vue vue, int x, int y){  quand les vue seront faite mettre ce constructeur
		public Robot(int equipe, int x, int y){
			super();
			this.equipe = equipe;
			this.c = new Coordonnee(x,y);
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
		public Vue getVue() {
			return vue;
		}
		public void setVue(Vue vue) {
			this.vue = vue;
		}
		public void subitTir(int degatTir){
			energie -= degatTir;
		}
		public void subitMine(){
			energie -=5;
		}
		public String toString() {
			return "Robot [equipe=" + equipe + ", energie=" + energie + ", vue=" + vue + ", c=" + c + "]";
		}
		public abstract boolean peutTirer();
		public abstract int getCoutAction();
		public abstract int getDeplacement();
		public abstract int getDegatTir();
		public abstract int getDegatMine();
		public abstract String getType();
		public abstract String getRepresentation();
		public abstract void attaquer();
		
		public void jouer(){
			int nbrDeplacement = this.getDeplacement();
			boolean dejaAttaquer = false;
			String action = "";
			while(!dejaAttaquer || nbrDeplacement > 0){
				action = saisieAction();
				if (action == "STOP".toLowerCase() || action == "STOP" ) {
					dejaAttaquer = true;
					nbrDeplacement = -1;
				}else if(action == "Attaquer".toLowerCase() || action == "Attaquer"){
					attaquer();
				}else if(action == "Deplacement".toLowerCase() || action == "Deplacement"){
				
				}
				
			}
		}
		
		private String saisieAction(){
			JFrame frame = new JFrame();
			
			String res ="";
			while(res != "STOP".toLowerCase() || res != "STOP" 
				||res != "Attaquer".toLowerCase() || res != "Attaquer"
				||res != "Deplacement".toLowerCase() || res != "Deplacement"){
				res = JOptionPane.showInputDialog(frame,"Entrez une action :\n"
						+ "\"STOP\" pour passer au robot suivant\n"
						+ "\"Attaquer\" pour attaquer\n"
						+ "\"Deplacement\" pour se deplacer\n");
			}
			return res;
		}
}

