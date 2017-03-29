package Cellule;

public class Coordonnee {
	//x longueur, y largeur
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public Coordonnee(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void ajouterCoordonnee(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Coordonnee c){
		return x==c.getX() && y==c.getY();
	}
	
}
