package Divers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Joueur {
	
	private String nom;
	private int equipe;
	private static int nbrEquipe = 1; 
	
	public Joueur(String n){
		nom = n;
		this.equipe = Joueur.nbrEquipe;
		Joueur.nbrEquipe++;		
	}

	public String getNom() {
		return nom;
	}

	public int getEquipe() {
		return equipe;
	}

	public static Joueur saisie(){
		JFrame frame = new JFrame();
		
		String res ="";
		while(res.length()==0){
			res = JOptionPane.showInputDialog(frame,"Entrez un nom pour le joueur "+Joueur.nbrEquipe+":");
		}
		return new Joueur(res);
	}
}
