import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Deplacement {
	

	
	
	public static void DeplacementRobot(Robot r,Cellule[][] plat){
		
		JFrame frame = new JFrame();
		String saisie = "";
		int x = 0;
		int y = 0;
		do{
	
			saisie = JOptionPane.showInputDialog(frame,"Entrez un direction");

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

