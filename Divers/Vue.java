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
    /**
     * crée la vue qu'aura un joueur sur le plateau
     * @param p = plateau
     * @param equipe
     */
	public Vue(Plateau p,int e){
		plat=p;
		equipe=e;
	}
    /**
     * crée un robot a une coordonnee donné
     * @param robot
     * @param coord
     */
	public void setRobot(Robot robot, Coordonnee coord){

		Cellule[][] cel = plat.getPlat();
		if(estOk(coord) && cel[coord.getX()][coord.getY()].estHerbe()){
			plat.getPlat()[coord.getX()][coord.getY()].setRobot(robot);
		}
	}
	
	public void setPlateau(Plateau p){
		plat=p;
	}
    /**
     * retire de l'energie a un robot selon les degat infligé par un autre robot
     * @param coord
     * @param degatTir
     */
	public void subitTir(Coordonnee coord,int degatTir){
		if(estOk(coord) && !plat.getPlat()[coord.getX()][coord.getY()].getR().equals(null) ){
			plat.getPlat()[coord.getX()][coord.getY()].getR().subitTir(degatTir);
		}
	}
    /**
     * verifie si les coordonne entrée ne depasse pas la longueur du plateau
     * @param coord
     * @return boolean
     */
	public boolean estOk(Coordonnee coord){
		return coord.getX()<=plat.getLongueur() && coord.getY()<=plat.getLargeur();
	}
    /**
     * crée une equipe
     * @param c = coordonnee
     * @param equipe
     */
	public void ajouterEquipe(Coordonnee c,int equipe){
		if(estOk(c)){
			plat.ajouterEquipe(c, equipe);
	
		}
	}
    /**
     * detruit une equipe
     * @param c
     */
	public void viderEquipe(Coordonnee c){
		if(estOk(c)){
			plat.viderEquipe(c);
		}
	}


}