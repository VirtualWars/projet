package Divers;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jeu {
	
	private String joueur1;
	private String joueur2;
	private Plateau plateau;
	private int nbrDeTour = 0;
	private int nbrDeTroupesParEquipe;
	private int largeur;
	private int longueur;
	private int pourcentage;
	
	public Jeu(){
		plateau = new Plateau(20,20,15);
		joueur1 = saisieJoueur(1);
		joueur2 = saisieJoueur(2);
		saisieTaille();
		saisiePourcentage();
		saisieNbrDeTroupesParEquipe();
		saisieDesTroupes(1);
		System.out.println(plateau);
		plateau.ajouterTireur(3, 4, 1);
	}
	
	private void saisieDesTroupes(int equipe){
		JFrame frame = new JFrame();
		String saisie = "";
		boolean saisieValide = false;
		while(!saisieValide){
			saisie = JOptionPane.showInputDialog(frame,"Rentrez le nombre de robot pour chaque type \n que vous désirez dans votre équipe\n"
					+ "( Sous la forme NbrDeTireur/NbrDePiegieur/NbrDeTank \n"
					+ "exemple 2/2/3 ) \n"
					+ "Vous pouvez avoir "+nbrDeTroupesParEquipe+" robot(s) dans votre équipe");
			saisieValide = testSaisieRobots(saisie);
		}
		for (int i = 0; i < Integer.valueOf(saisie.charAt(0)); i++) {
			plateau.ajouterTireur(-1, -1, equipe);
		}
	}
	
	private boolean testSaisieRobots(String s){
		if (!(s.charAt(1)=='/' && s.charAt(3)=='/')) {
			return false;
		}
		if((Integer.valueOf(""+s.charAt(0))+Integer.valueOf(""+s.charAt(2))+Integer.valueOf(""+s.charAt(4)))!=this.nbrDeTroupesParEquipe){
			return false;
		}
		else{
			return true;
		}
	}
	
	
	private void saisieNbrDeTroupesParEquipe(){
		JFrame frame = new JFrame();
		int saisie = -1;
		while(saisie <= 0 || saisie >= 10 ){
			saisie = Integer.valueOf(JOptionPane.showInputDialog(frame,"Rentrez le nombre de robots par équipe"));
		}
		this.nbrDeTroupesParEquipe = saisie;
	}
	
	private void saisiePourcentage() {
		
		JFrame frame = new JFrame();
		int saisie = 101;
		while(saisie > 100 || saisie < 0){
			saisie = Integer.valueOf(JOptionPane.showInputDialog(frame,"Rentrez un pourcentage d'obstacle ( entre 0 et 100)"));

		}
		this.pourcentage = saisie;
		
	}

	private String saisieJoueur(int equipe){
		
		JFrame frame = new JFrame();
		
		String res ="";
		while(res == ""){
			res = JOptionPane.showInputDialog(frame,"Entrez un nom pour le joueur "+equipe+":");
		}
		return res;
	}
	
	private void saisieTaille(){
		JFrame frame = new JFrame();
		String saisie = "";
		boolean saisieValide = false;
		while(!saisieValide){
			saisie = JOptionPane.showInputDialog(frame,"Rentrez une taille ( sous la forme largeur/longueur)");
			saisieValide = testValide(saisie);
		}
		this.largeur = Integer.valueOf(saisie.substring(0,2));
		this.longueur = Integer.valueOf(saisie.substring(3,5));
	}

	private boolean testValide(String s){
		if (s.length() != 5) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			if(i != 2){
				if (!(s.charAt(i)>='0' && s.charAt(i)<='9')) {
					System.out.println("cz");
					return false;
				}
			}else{
				if(s.charAt(i)!='/'){
					System.out.println("c");
					return false;
				}
			}
		}
		return true;
	}
}
