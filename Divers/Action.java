package Divers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cellule.Robot;

public class Action {
	
	public static void actionRobot(Robot r,Plateau p){
		boolean dejaAttaquer = false;
		String action = "";
		while(!dejaAttaquer || r.getDeplacement() > 0){
			action = saisieAction(r);
			if (action.equals("Passer au robot suivant")) {
				dejaAttaquer = true;
				r.setDeplacement(-1);
			}else if(action.equals("Attaquer") && r.peutTirer()){
				attaquer(r,p);
			}else if(action.equals("Deplacement")){
				r.deplacement();
			}
			
		}
		r.resetDeplacement();
	}
	
	private static String saisieAction(Robot r){
		Object[] possibleValues = { "Attaquer", "Deplacement", "Passer au robot suivant" };
		String res = (String) JOptionPane.showInputDialog(null,
		"Quelle action veux tu effectuer avec le "+r.getType()+" situé en "+r.getC(), "Choix actions",
		JOptionPane.INFORMATION_MESSAGE, null,
		possibleValues, possibleValues[0]);
		return res;
	}
	
	private static void attaquer(Robot robot,Plateau plateau) {
		JFrame frame = new JFrame();
		String res ="";
	//	while(!testCoordonneeAttaqueValide(res)){
			
			res = JOptionPane.showInputDialog(frame,"Entrez une coordonnee ou attaquer");
			
		//}
		for (Robot r : plateau.getListeRobot()) {
			if(r.getC().getX()==Integer.valueOf(res.substring(0,2)) && r.getC().getX()==Integer.valueOf(res.substring(3,5))){
				r.setEnergie(r.getEnergie()-robot.getDegatTir());
			}
		}
		robot.getVue().setPlateau(plateau);
		System.out.println(robot.getVue().getPlateau());
	}
	
	/*public boolean testCoordonneeAttaqueValide(String n){
		if(n.length() != 3 && n.length() != 5){return false;}
		int x,y;
		if(n.length() == 3){
			
			x = (int) n.charAt(0)	- (int) '0';
			
			y = 
		
		}
		
		else{
			x = (int)
		}
					
	}*/
	
	
}
