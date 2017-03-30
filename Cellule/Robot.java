package Cellule;
//import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import Divers.Joueur;
import Divers.Plateau;
import Divers.Vue;

public abstract class Robot {

		private Cellule[][] plat;
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
		
		
		//public Robot(int equipe, Vue vue, int x, int y){  quand les vue seront faite mettre ce constructeur
		public Robot(int equipe, int x, int y,int deplacement,int coutAction,int coutDeplc,int degatTir,int degatMine,int portee,String representation,Cellule[][] plat){
			
			this.equipe = equipe;
			this.c = new Coordonnee(x,y);
			this.deplacement=deplacement;
			this.coutAction=coutAction;
			this.coutDeplc=coutDeplc;
			this.degatTir=degatTir;
			this.degatMine=degatMine;
			this.representation=representation;
			this.portee=portee;
			this.plat = plat;
			
		
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
		public String getRepresentation() {
			return representation;
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
	
		public abstract String getType();
		
		
		//RAJOUTER DES MESSAGES D'ERREUR
		public void attaquer(){
				JFrame frame = new JFrame();
				int i =0;
				String saisie ="";
				boolean saisieCorrect = false;
				while(!saisieCorrect){
					
					
					saisie = JOptionPane.showInputDialog(frame,"Entrez la case sur laquel vous voulez \n effectuez l'action\n"
							+ "sous la forme ( ligne(longueur)/ colonne(largeur) )\n"
							+ "vous avez une portée de" + this.portee + " cases");
					saisieCorrect = testSaisieCorrect(saisie);
					//&& attaqueOk(new Coordonnee(saisie.charAt(0),saisie.charAt(2)),getPlateau()
					if(!saisieCorrect){
						String erreur = JOptionPane.showInputDialog(null, "Erreur dans la saisie, portee trop courte \n ou coordonnees mauvaise ou probleme de saisie. \n Voulez vous reessayer ?","Erreur",JOptionPane.ERROR_MESSAGE);
						
						if(erreur.equals("Non") || erreur.equals("non") || erreur.equals("NON")){
							saisieCorrect = true; i++;
						}
						
						if(!testSaisieCorrect(saisie)){
							System.out.println("c'est thibait");
						}
						
						if(!bonSensAttaque(new Coordonnee(saisie.charAt(0),saisie.charAt(2)))){
							System.out.println("C BONSENSATTAQUE,saisie.charAt(2))");
						}
						if(! !vue.getPlateau().getPlat()[new Coordonnee(saisie.charAt(0),saisie.charAt(2)).getX()][new Coordonnee(saisie.charAt(0),saisie.charAt(2)).getY()].getR().equals(null)){
							System.out.println("C VUE;GET PLAT BLABLA");
						}


					}
				}
				Coordonnee c = new Coordonnee(saisie.charAt(0),saisie.charAt(2));	
				if(i==0){
					Robot r = vue.getPlateau().getPlat() [c.getX()] [c.getY()].getR();
					r.setEnergie(r.getEnergie()-this.degatTir);
				}
			}

		private boolean testSaisieCorrect(String s){
				if (s.length() != 3) {
					return false;
				}
				for (int i = 0; i < s.length(); i++) {
					if(i != 1){
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
			}

		abstract public boolean bonSensAttaque(Coordonnee c);
		
		public void jouer(){
			
			boolean dejaAttaquer = false;
			String action = "";
			while(!dejaAttaquer || deplacement > 0){
				action = saisieAction();
				if (action.equals("stop") || action.equals("STOP" )) {
					dejaAttaquer = true;
					this.deplacement = -1;
				}else if(action.equals("attaquer") || action.equals("Attaquer")){
					attaquer();
				}else if(action.equals("deplacement") || action.equals("Action")){
					deplacement();
				}
				
			}
		}
		
		
		
		private void deplacement(){
			JFrame frame = new JFrame();
			String saisie = "";
			while((saisie != "STOP" || saisie != "stop" || saisie != "Stop") &&
					 this.deplacement > 0){
				saisie = JOptionPane.showInputDialog(frame,"Entre la direction vers la quelle vous voulez allez\nhaut/bas/gauche/droite");
				if(saisie.equals("haut")){// && plat[c.getX()][c.getY()+1] == null
					System.out.println("fe");
					this.c = new Coordonnee(c.getX(), c.getY()+1);
				}				
			}
		}
		
		
		
		private String saisieAction(){
			JFrame frame = new JFrame();
			
			String res ="";
			while(!res.equals("STOP".toLowerCase()) && !res.equals("STOP") 
				&& !res.equals("Attaquer".toLowerCase()) && !res.equals("Attaquer")
				&& !res.equals("Deplacement".toLowerCase()) && !res.equals("Deplacement")){
				res = JOptionPane.showInputDialog(frame,"Entrez une action :\n"
						+ "\"STOP\" pour passer au robot suivant\n"
						+ "\"Attaquer\" pour attaquer\n"
						+ "\"Deplacement\" pour se deplacer\n");
			}
			return res;
		}
}

