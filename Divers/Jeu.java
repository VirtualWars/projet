package Divers;
import Cellule.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class Jeu {
	
	private Joueur j1;
	private Joueur j2;
	private Plateau plateau;
	private int nbrDeTour = 0;
	private int nbrDeTroupesParEquipe = 0;
	private int largeur;
	private int longueur;
	private int pourcentage;
    /**
     * crée un nouveau plateau
     * initialise les deux joueurs
     *
     * ouvre une fenetre pour demander a l'utilisateur :
     * 1) taille du plateau
     * 2) nombre de robot par equipe
     * 3) type des robots
     *
     * afiche le plateau
     */	
	public Jeu(){
		j1 = Joueur.saisie();
		j2 = Joueur.saisie();
		saisieTaille();
		saisiePourcentage();
		plateau = new Plateau(longueur,largeur,pourcentage);
		saisieNbrDeTroupesParEquipe();
		saisieDesTroupes(1);
		saisieDesTroupes(2);
		System.out.println(plateau);
		
	}
    /**
     * effectue une action pour un robot d'une certaine equipe selon le tour de jeu
     */
	public void Jouer(){
		boolean jeuFini = false;
		int equipeJoueur=0;
		int gagnant = 0;
		int premier,second;
		Random whoFirst = new Random();
		double test = whoFirst.nextInt()+100;
		if(test%2 ==0){
			premier = 1;
			second = 2;}
		else{premier = 2;
			second = 1 ;}
		
		while( !jeuFini ){
			if((nbrDeTour%2)==0){equipeJoueur = premier;}
			else{equipeJoueur = second;}
			ArrayList<Robot> l = listRobotParEquipe(equipeJoueur);
			for (Robot r : l) {
				Action.actionRobot(r, plateau);
			}
			nbrDeTour++;
			gagnant = testGagnant(plateau.getListeRobot());
			if(gagnant > 0){
				jeuFini = true;
			}
		}
		String nomGagnant = "";
		if(gagnant == 1){ nomGagnant = j1.getNom();}
		else{ nomGagnant = j2.getNom();}
		System.out.print(nomGagnant+" a gagné");
	}
	
	
	

	
	
    /**
     * r'envoie le joueur gagnant si il en a un 
     */
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
			return 2;
		}else if(nbrRobot2 == 0){
			return 1;
		}else{
			return 0;
		}
		
	}
    /**
     * ajoute des robot dans une liste pour chaque equipe
     * @param e = equipe
     * @return liste de robot
     */
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
			do{
				saisie = JOptionPane.showInputDialog(frame,"Rentrez le nombre de robot pour chaque type \n que vous désirez dans votre équipe\n"
						+ "( Sous la forme NbrDeTireur/NbrDePiegieur/NbrDeTank \n"
						+ "exemple 2/2/3 ) \n"
						+ "Vous pouvez avoir "+nbrDeTroupesParEquipe+" robot(s) dans votre équipe","Equipe " + equipe,JOptionPane.QUESTION_MESSAGE);
			}while(saisie.length()==0);
			saisieValide = testSaisieRobots(saisie);
		}
		for (int i = 0; i < Integer.valueOf(saisie.charAt(0)+""); i++) {
			if(equipe == 1){
				plateau.ajouterTireur( 0, 0, equipe,this.plateau);
			}
			if(equipe == 2){
				plateau.ajouterTireur(longueur-1,largeur-1,equipe,this.plateau);
			}
		}
		
		
		for (int i = 0; i < Integer.valueOf(saisie.charAt(2)+""); i++) {
			if(equipe == 1){
				plateau.ajouterPiegeur( 0, 0, equipe,this.plateau);
			}
			if(equipe == 2){
				plateau.ajouterPiegeur(longueur-1,largeur-1,equipe,this.plateau);
			}
		}
		for (int i = 0; i < Integer.valueOf(saisie.charAt(4)+""); i++) {
			if(equipe == 1){
				plateau.ajouterChar( 0, 0, equipe,this.plateau);
			}
			if(equipe == 2){
				plateau.ajouterChar(longueur-1,largeur-1,equipe,this.plateau);
			}
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
	
	// protéger la saisie ici !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private void saisieNbrDeTroupesParEquipe(){
		JFrame frame = new JFrame();
		int saisie = -1;
		String test;
		while(saisie <= 0 || saisie >= 10 ){
			do{
				test=JOptionPane.showInputDialog(frame,"Rentrez le nombre de robots par équipe");
			}while(test.length()==0);
			saisie = Integer.valueOf(test);
		}
		this.nbrDeTroupesParEquipe = saisie;
	}
	
	private void saisiePourcentage() {
		
		JFrame frame = new JFrame();
		String test;
		int saisie = 101;
		while(saisie > 100 || saisie < 0){
			do{
				test=JOptionPane.showInputDialog(frame,"Rentrez un pourcentage d'obstacle ( entre 0 et 100)");
			}while(test.length()==0);
			saisie = Integer.valueOf(test);

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
	
	

	
	//private boolean testCoordonneeAttaqueValide(String s){   A FAIRE 
		
	
	
	
		/*String saisie = "";
		while(r.getDeplacement() > 0){
			
			Object[] possibleValues = { "Haut", "Bas", "Gauche","Droite","Arréter de se déplacer" };
			saisie = (String) JOptionPane.showInputDialog(null,
			"Quelle action veux tu effectuer ?\n Il reste " + r.getDeplacement() + " deplacement possible avec ce Robot." , "Choix actions pour " + r.getType() + " " +  r.getC(),
			JOptionPane.INFORMATION_MESSAGE, null,
			possibleValues, possibleValues[0]);
			Coordonnee test = r.getC();
			if(r.getY()+1 < largeur && saisie.equals("Droite") && plateau.getPlat()[r.getX()][r.getY()+1].estHerbe()){
				r.setCoordonnee(r.getX(), r.getY()+1);
				r.setDeplacement(r.getDeplacement()-1);
			}else if(r.getY()-1 >= 0 && saisie.equals("Gauche") && plateau.getPlat()[r.getX()][r.getY()-1].estHerbe()){
				r.setCoordonnee(r.getX(), r.getY()-1);
				r.setDeplacement(r.getDeplacement()-1);
			}else if(r.getX()+1 < longueur && saisie.equals("Bas") && plateau.getPlat()[r.getX()+1][r.getY()].estHerbe()){
				r.setCoordonnee(r.getX()+1, r.getY());
				r.setDeplacement(r.getDeplacement()-1);
			}else if(r.getX()-1 >= 0 && saisie.equals("Haut") && plateau.getPlat()[r.getX()-1][r.getY()].estHerbe()){
				r.setCoordonnee(r.getX()-1, r.getY());
				r.setDeplacement(r.getDeplacement()-1);
			}else if(saisie.equals("Arréter de se déplacer")){
				r.setDeplacement(-1);

			}
			if((r.getC().getX()==0 && r.getC().getY()==1) || (r.getC().getX()==largeur-1 && r.getC().getY()==longueur-2)){
				r.setDeplacement(r.getDeplacement()+1);
			}
			r.getVue().setPlateau(plateau);
			
			if(!r.getC().equals(test)){
				r.setEnergie(r.getEnergie()-r.getCoutDeplc());
				System.out.println(r.getVue().getPlateau());
			}
			else{
				System.out.println(plateau);				
			}
			
		}*/
	
	public int getLargeur() {
		return largeur;
	}
	public int getLongueur() {
		return longueur;
	}
	
}