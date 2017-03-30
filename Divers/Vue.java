package Divers;
import Cellule.*;
public class Vue {
	private Plateau plat;
	private int equipe;
	
	public int getEquipe(){
		return equipe;
	}
	public Plateau getPlateau(){
		return plat;
	}
	
	public Vue(){
	}
	
	public void setRobot(Robot robot, Coordonnee coord){

		Cellule[][] cel = plat.getPlat();
		if(estOk(coord) && cel[coord.getX()][coord.getY()].estHerbe()){
			plat.getPlat()[coord.getX()][coord.getY()].setRobot(robot);
		}
	}

	//videcase ???
	
	public void subitTir(Coordonnee coord,int degatTir){
		if(estOk(coord) && !plat.getPlat()[coord.getX()][coord.getY()].getR().equals(null) ){
			plat.getPlat()[coord.getX()][coord.getY()].getR().subitTir(degatTir);
		}
	}

	public boolean estOk(Coordonnee coord){
		return coord.getX()<=plat.getLongueur() && coord.getY()<=plat.getLargeur();
	}
	
	public void ajouterEquipe(Coordonnee c,int equipe){
		if(estOk(c)){
			plat.ajouterEquipe(c, equipe);
	
		}
	}
	
	public void viderEquipe(Coordonnee c){
		if(estOk(c)){
			plat.viderEquipe(c);
		}
	}


}