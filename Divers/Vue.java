package Divers;
import java.util.ArrayList;

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
	
	public Vue(Plateau p,int e){
		this.equipe=e;
		this.plat=p;
		Cellule [][] cell = plat.getPlat();
		for(int i = 0;i<cell.length;i++){
			for(int j = 0;i<cell[2].length;j++){
				if(cell[i][j].contientMine() != equipe){
					cell[i][j].setMine(0);
				}
			}
		}
		plat.setPlat(cell);
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