package Projet;

import java.util.List;

public class Piegeur extends Robot {
		private static int deplacement = 1;
		private static int coutAction = -2;
		private static int coutDeplc = -2;
		private static int degatTir = 0;
		private static int degatMine = 2;
		private static char representation = 'P';
		
		
		public Piegeur(int equipe, int x, int y) {
			super(equipe, x, y);
		}
		public static int getDeplacement() {
			return deplacement;
		}
		public static void setDeplacement(int deplacement) {
			Piegeur.deplacement = deplacement;
		}
		public static int getCoutAction() {
			return coutAction;
		}
		public int getDegatTir() {
			return degatTir;
		}
		public int getDegatMine() {
			return degatMine;
		}
		public char getRepresentation() {
			return  representation;
		}
		
		@Override
		public boolean peutTirer() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public int getCoupAction() {
			return coutAction;
		}
		@Override
		public int getCoupDeplacement() {
			return coutDeplc;
		}
		@Override
		public List<Coordonnee> getDeplacements() {
			return null;
		}
}
