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
	
    /**
	 * crée une Coordonnee selon le x et le y donnés en param
	 * @param x
	 * @param y
	 */
	public Coordonnee(int x, int y) {
		this.x = x;
		this.y = y;
	}
    /**
	 * remplace les valeurs de la Coordonnee selon le x et le y donnés en paramétre
	 * @param x
	 * @param y
	 */
	public void ajouterCoordonnee(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Coordonnee c){
		return x==c.getX() && y==c.getY();
	}
	public String toString(){
		return "("+this.x+","+this.y+")";
	}
	
}
