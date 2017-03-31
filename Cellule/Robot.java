package Cellule;
//import java.util.List;


public abstract class Robot {

		private int equipe;
		private int energie = 3;
		private Coordonnee c;
		private  int deplacement;
		private  int coutAction;
		private  int coutDeplc;
		private  int degatTir;
		private  int degatMine;
		private  int portee;
		private  String representation = "R";
//		private Vue v;
		
		
		//public Robot(int equipe, Vue vue, int x, int y){  quand les vue seront faite mettre ce constructeur
		public Robot(int equipe, int x, int y,int deplacement,int coutAction,int coutDeplc,int degatTir,int degatMine,int portee,String representation){
			
			this.equipe = equipe;
			this.c = new Coordonnee(x,y);
			this.deplacement=deplacement;
			this.coutAction=coutAction;
			this.coutDeplc=coutDeplc;
			this.degatTir=degatTir;
			this.degatMine=degatMine;
			this.representation=representation;
			this.portee=portee;	
			//this.v = new Vue();
			
		
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
}

