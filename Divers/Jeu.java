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
	private Vue vue;
	
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
		int gagnant = 0;
		while( !jeuFini ){
			if((nbrDeTour%2)==0){equipeJoueur = 1;}
			else{equipeJoueur = 2;}
			ArrayList<Robot> l = listRobotParEquipe(equipeJoueur);
			for (Robot r : l) {
				actionRobot(r);
			}
			nbrDeTour++;
			gagnant = testGagnant(l);
			if(gagnant > 0){
				jeuFini = true;
			}
		}
		System.out.print("L'équipe "+gagnant+" a gagné");
	}
	
	private int testGagnant(ArrayList<Robot> l){
		int nbrRobot1 = 0;
		int nbrRobot2 = 0;
		for (Robot r : l) {
			if(r.getEquipe()==1){
				nbrRobot1++;
			}else if(r.getEquipe()==2){
				nbrRobot2++;
			}
		}
		if(nbrRobot1 == 0){
			return 1;
		}else if(nbrRobot2 == 0){
			return 2;
		}else{
			return 0;
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
			action = saisieAction(r);
			if (action.equals("stop") || action.equals("STOP" )) {
				dejaAttaquer = true;
				r.setDeplacement(-1);
			}else if(action.equals("attaquer") || action.equals("Attaquer")){
				attaquer(r);
			}else if(action.equals("deplacement") || action.equals("Deplacement")){
				deplacement(r);
			}
			
		}
	}
	private String saisieAction(Robot r){
		JFrame frame = new JFrame();
		
		String res ="";
		while(!res.equals("STOP") 
			&& !res.equals("Attaquer".toLowerCase()) && !res.equals("Attaquer")
			&& !res.equals("Deplacement".toLowerCase()) && !res.equals("Deplacement")){
			res = JOptionPane.showInputDialog(frame,"Entrez une action pour le robot situé en ("+r.getX()+","+r.getY()+"):\n"
					+ "\"STOP\" pour passer au robot suivant\n"
					+ "\"Attaquer\" pour attaquer\n"
					+ "\"Deplacement\" pour se deplacer\n");
		}
		return res;
	}
	private void deplacement(Robot r){
		JFrame frame = new JFrame();
		String saisie = "";
		while((!saisie.equals("STOP") || !saisie.equals("stop") || !saisie.equals("Stop")) 
				&& r.getDeplacement() > 0){
			saisie = JOptionPane.showInputDialog(frame,"Entre la direction vers la quelle vous voulez allez\nhaut/bas/gauche/droite\n Il te restre "+r.getDeplacement()+" deplacements");
			if(r.getY()+1 < largeur && saisie.equals("droite") && plateau.getPlat()[r.getX()][r.getY()+1].estHerbe()){
				r.setCoordonnee(r.getX(), r.getY()+1);
				r.setDeplacement(r.getDeplacement()-1);
				System.out.println(plateau);
			}else if(r.getY()-1 >= 0 && saisie.equals("gauche") && plateau.getPlat()[r.getX()][r.getY()-1].estHerbe()){
				r.setCoordonnee(r.getX(), r.getY()-1);
				r.setDeplacement(r.getDeplacement()-1);
				System.out.println(plateau);				
			}else if(r.getX()+1 < longueur && saisie.equals("bas") && plateau.getPlat()[r.getX()+1][r.getY()].estHerbe()){
				r.setCoordonnee(r.getX()+1, r.getY());
				r.setDeplacement(r.getDeplacement()-1);
				System.out.println(plateau);				
			}else if(r.getX()-1 >= 0 && saisie.equals("haut") && plateau.getPlat()[r.getX()-1][r.getY()].estHerbe()){
				r.setCoordonnee(r.getX()-1, r.getY());
				r.setDeplacement(r.getDeplacement()-1);
				System.out.println(plateau);				
			}
		}
	}
	
	private void attaquer(Robot r){
		JFrame frame = new JFrame();
		int i =0;
		String saisie ="";
		boolean saisieCorrect = false;
		while(!saisieCorrect){
			
			saisie = JOptionPane.showInputDialog(frame,"Robot situé en ("+r.getX()+","+r.getY()+".Entrez la case sur laquelle vous voulez effectuer l'action\n"
					+ "sous la forme ( ligne(longueur)/ colonne(largeur) )\n"
					+ "vous avez une portée de" + r.getPortee() + " cases");
			//attention GROSSE VERIF A FAIRE
			//testsaisieok
			saisieCorrect = attaqueOk((new Coordonnee((int) saisie.charAt(0)-(int) '0', (int) saisie.charAt(2)-(int) '0')),this.plateau,r);
			if(!saisieCorrect){
				String erreur = JOptionPane.showInputDialog(null, "Erreur dans la saisie, port�e trop courte \n ou coordonnees mauvaise ou probl�me de saisie. \n Voulez vous r�essayer ?","Erreur",JOptionPane.ERROR_MESSAGE);
				if(erreur.equals("Non") || erreur.equals("non") || erreur.equals("NON")){ saisieCorrect = true; i++;}
			


			
		}
		Coordonnee c = new Coordonnee(saisie.charAt(0),saisie.charAt(2));	
		if(i==0){
			Robot r1 = vue.getPlateau().getPlat() [c.getX()] [c.getY()].getR();
			r1.setEnergie(r1.getEnergie()-r.getDegatTir());
		}
	}
	}

	public boolean attaqueOk(Coordonnee coord,Plateau plat,Robot r){
		return coord.getX()<=plat.getLongueur() && coord.getY()<=plat.getLargeur() && r.bonSensAttaque(coord) &&   !plat.getPlat()[coord.getX()][coord.getY()].getR().equals(null) ;
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

	
}