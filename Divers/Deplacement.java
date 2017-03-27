package Divers;

public class Deplacement {
	

	
	
	public static void DeplacementRobot(Robot r,Cellule[][] plat){
		
		JFrame frame = new JFrame();
		frame.setBackground(new Color(10, 10, 10));
		String saisie = "";
		int x = r.getX();
		int y = r.getY();
		do{
	
			saisie = JOptionPane.showInputDialog(frame,"Entrez un direction (haut/bas/gauche/droite)");

			switch(saisie){

			case "gauche" : 
				x = r.getX();
				y = r.getY()-1;
				break;
				
			case "droite" : 
				x = r.getX();
				y = r.getY()+1;
				break;
				
			case "haut" : 
				x = r.getX()-1;
				y = r.getY();
				break;
				
			case "bas" :
				x = r.getX()+1;
				y = r.getY();
				break;
			}
			
			
		}while((saisie != "gauche" || saisie != "droite" || saisie != "haut" ||saisie != "bas") 
				&& (x < 0 || y < 0 || x >= plat.length || y >= plat[2].length));
		if(plat[x][y].estHerbe()){
			r.setCoordonnee(x, y);
		}
		
	}
}

