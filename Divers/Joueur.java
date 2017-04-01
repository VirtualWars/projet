package Divers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Joueur {
	
	private String nom;
	private int equipe;
	private static int nbrEquipe = 1; 
    /**
	 * crée un joueur avec le nom passé en parametre et lui attribue une équipe
	 * @param n = nom du joueur
	 */
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
    /**
	 * demande a l'utilisateur le nom de son personnage
	 * @return le nouveau joueur avec son nom
	 */
	public static Joueur saisie(){
		JFrame frame = new JFrame();
		
		String res ="";
		while(res.length()==0){
			res = JOptionPane.showInputDialog(frame,"Entrez un nom pour le joueur "+Joueur.nbrEquipe+":");
		}
		return new Joueur(res);
	}
}
