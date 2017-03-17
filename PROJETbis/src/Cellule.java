
public abstract class Cellule {
		
	protected Coordonnee c;
	protected int base;
	protected int mine;
	protected Robot r;
	
	public Cellule(int x, int y) {
		c = new Coordonnee(x,y);
	}
	
	public Coordonnee getC() {
		return c;
	}

	public Robot getR() {
		return r;
	}
	
	public int contientMine(){
		return mine;
	}
	public int estBase(){
		return base;
	}

	public String toString() {
		return "Cellule [c=" + c + ", base=" + base + ", mine=" + mine + ", r=" + r + "]";
	}
	
	abstract void DeplacerSur(Robot robot);
	abstract void ajoute(int equipe);
	abstract void viderCase();
	
	
	
	
	
	
}
