package projet;

import java.util.List;

public class Piegeur extends Robot{
	
	public Piegeur(int equipe, int x, int y) {
		super(equipe, x, y);
	}
	private static int deplacement =1;
	private static int coutAction = -2;
	private static int coutDeplc = 2;
	private static int degatTir = 0;
	private static int degatMine = -2;
	private static String type = "Piegeur";
	
	
	public static int getDeplacement() {
		return deplacement;
	}
	public static void setDeplacement(int deplacement) {
		Piegeur.deplacement = deplacement;
	}
	public static int getCoutAction() {
		return coutAction;
	}
	public static int getCoutDeplc() {
		return coutDeplc;
	}
	public int getDegatTir() {
		return degatTir;
	}
	public int getDegatMine() {
		return degatMine;
	}
	public String getType() {
		return type;
	}
	
		

	public boolean peutTirer() {
		return false;
	}
	
	
	public int getCoupAction() {
		return coutAction;
	}
	
	
	public int getCoupDeplacement() {
		return coutDeplc;
	}

	
	public List<Coordonnee> getDeplacements() {
		return null;
	}
	
	
}
