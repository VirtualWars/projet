package Divers;
import Cellule.*;
public class Vue {
	private Plateau plat;
	private int equipe;
	
	public int getEquipe(){
		return equipe;
	}
	
	public Vue(Plateau p, int equipe){
		plat = p;
		this.equipe=equipe;
	}
	
	public void setRobot(Robot robot, Coordonnee coord){

		Cellule[][] cel = plat.getPlat();
		if(estOk(coord) && cel[coord.getX()][coord.getY()].estHerbe()){
			plat.getPlat()[coord.getX()][coord.getY()].setRobot(robot);
		}
	}

	//videcase ???
	
	public void subitTir(Coordonnee coord){
		if(estOk(coord) && !plat.getPlat()[coord.getX()][coord.getY()].getR().equals(null) ){
			plat.getPlat()[coord.getX()][coord.getY()].getR().subitTir();
		}
	}

	public boolean estOk(Coordonnee coord){
		return coord.getX()<=plat.getLongueur() && coord.getY()<=plat.getLargeur();
	}


}
