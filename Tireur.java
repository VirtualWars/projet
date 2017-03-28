package Divers;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cellule.Coordonnee;
import Cellule.Robot;

public class Tireur extends Robot{

	private static int deplacement;
	private static int coutAction;
	private static int coutDeplc;
	private static int degatTir;
	private static int degatMine = 0;
	private static String representation = "T";
	
	/*public void setDeplcament(int deplacement){
		this.deplacement = deplacement;
	}*/
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
	}
	@Override
	public void attaquer() {
		JFrame frame = new JFrame();
		
		String saisie ="";
		boolean saisieCorrect = false;
		while(!saisieCorrect){
			saisie = JOptionPane.showInputDialog(frame,"Entrez la case sur laquel vous voulez \n effectuez l'action\n"
					+ "sous la forme ( ligne/colonne )\n"
					+ "vous avez une portée de 7 cases");
			saisieCorrect = testSaisieCorrect(saisie);
		}
		System.out.println("Action a faire ( surtout la portée avec la portée");
		
	}
	private boolean testSaisieCorrect(String s){
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
	}
}