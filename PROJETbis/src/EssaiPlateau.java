//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

public class EssaiPlateau {

	public static void main(String[] args) {
		Plateau jeu = new Plateau(10,20,15);
		jeu.ajouterTireur(2, 5, 1);
		//jeu.buildPlateau(10,20,50);
		System.out.println(jeu);
		while(true){
			Deplacement.DeplacementRobot(jeu.getListRobot().get(0),jeu.getPlat());
			System.out.println(jeu);
		}

	//	jeu.drawLineLand(0,0,9,19);
	//	System.out.println(jeu.affichePlateau());
		

		
	}
/*	private String saisieDirection(){
		JFrame frame = new JFrame();
		String saisie = "";
		do{
	
			saisie = JOptionPane.showInputDialog(frame,"Entrez un direction");

		}while(saisie != "gauche" || saisie == "droite" || saisie == "haut" ||saisie == "bas");
		return saisie;
	}*/
	
	
	


}
