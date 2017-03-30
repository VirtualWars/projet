package Divers;
import Cellule.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jeu {
	
	private Joueur j1;
	private Joueur j2;
	private Plateau plateau;
	private int nbrDeTour = 0;
	private int nbrDeTroupesParEquipe = 0;
	private int largeur;
	private int longueur;
	private int pourcentage;
	
	public Jeu(){
		j1 = Joueur.saisie();
		j2 = Joueur.saisie();
		saisieTaille();
		saisiePourcentage();
		plateau = new Plateau(longueur,largeur,pourcentage);
		saisieNbrDeTroupesParEquipe();
		saisieDesTroupes(1);
		plateau.ajouterTireur(1, 2, 1);
		plateau.ajouterTireur(2, 2, 2);
		System.out.println(plateau);
		
	}
	public void Jouer(){
		boolean jeuFini = false;
		int equipeJoueur=0;
		while( !jeuFini ){
			if((nbrDeTour%2)==0){equipeJoueur = 1;}
			else{equipeJoueur = 2;}
			ArrayList<Robot> l = listRobotParEquipe(equipeJoueur);
			for (Robot r : l) {
				actionRobot(r);
			}
		}	
	}
	
	public ArrayList<Robot> listRobotParEquipe(int e){
		ArrayList<Robot> l = new ArrayList<Robot>();
		for (Robot r : plateau.getListeRobot()) {
			if(r.getEquipe()==e){
				l.add(r);
			}
		}
		return l;
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

	
	private void saisieTaille(){
		JFrame frame = new JFrame();
		String saisie = "";
		boolean saisieValide = false;
		while(!saisieValide){
			saisie = JOptionPane.showInputDialog(frame,"Rentrez une taille ( sous la forme largeur/longueur)");
			saisieValide = testCoordonneeValide(saisie);
		}
		this.largeur = Integer.valueOf(saisie.substring(0,2));
		this.longueur = Integer.valueOf(saisie.substring(3,5));
	}

	private boolean testCoordonneeValide(String s){
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
	
	private void actionRobot(Robot r){
		boolean dejaAttaquer = false;
		String action = "";
		while(!dejaAttaquer || r.getDeplacement() > 0){
			action = saisieAction();
			if (action.equals("stop") || action.equals("STOP" )) {
				dejaAttaquer = true;
				r.setDeplacement(-1);
			}else if(action.equals("attaquer") || action.equals("Attaquer")){
				//attaquer();
			}else if(action.equals("deplacement") || action.equals("Deplacement")){
				deplacement(r);
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
	private void deplacement(Robot r){
		JFrame frame = new JFrame();
		String saisie = "";
		while((!saisie.equals("STOP") || saisie != "stop" || saisie != "Stop") &&
				 r.getDeplacement() > 0){
			saisie = JOptionPane.showInputDialog(frame,"Entre la direction vers la quelle vous voulez allez\nhaut/bas/gauche/droite");
			if(saisie.equals("droite") && plateau.getPlat()[r.getX()][r.getY()+1].estHerbe()
					&& r.getY()+1 < largeur){
				r.setCoordonnee(r.getX(), r.getY()+1);
				System.out.print("\033[2J");
				System.out.println(plateau);
			}else if(saisie.equals("gauche") && plateau.getPlat()[r.getX()][r.getY()-1].estHerbe()
					&& r.getY()-1 >= 0){
				r.setCoordonnee(r.getX(), r.getY()-1);
				System.out.print("\033[2J");
				System.out.println(plateau);				
			}else if(saisie.equals("bas") && plateau.getPlat()[r.getX()+1][r.getY()].estHerbe()
					&& r.getX()+1 < longueur){
				r.setCoordonnee(r.getX()+1, r.getY());
			    System.out.print("\033[2J");
				System.out.println(plateau);				
			}else if(saisie.equals("haut") && plateau.getPlat()[r.getX()-1][r.getY()].estHerbe()
					&& r.getX()-1 >= 0 ){
				r.setCoordonnee(r.getX()-1, r.getY());
				System.out.print("\033[2J");
				System.out.println(plateau);				
			}
		}
	}
	
}