
public class Cellule {
		
	protected Coordonnee c;
	protected int base;
	protected int mine;
	protected boolean rocher;
	protected boolean arbre;
	protected boolean herbe;
	protected Robot r;
	
	
	public boolean setToRocher(){
		if(base != 0){
			return false;
		}
		else{
			rocher = true;
			return true;
		}
	}
	public boolean setToArbre(){
		if(base != 0){
			return false;
		}
		else{
			arbre = true;
			return true;
		}
	}
	public boolean setToHerbe(){
		if(base != 0){
			return false;
		}
		else{
			herbe = true;
			rocher = false;
			arbre = false;
			return true;
		}
	}
	public void setTobase(int equipe){
		base = equipe;
	}
	public boolean estHerbe(){
		return herbe;
	}
	public boolean estRocher(){
		return rocher;
	}
	public boolean estArbre(){
		return arbre;
	}
	
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
	
	//abstract void DeplacerSur(Robot robot);
	//abstract void ajoute(int equipe);
	//abstract void viderCase();
	
	public char getRepresentation(){
		if(base != 0){
			return 'B';
		}		
		if(arbre){
			return 'A';
		}
		if(rocher){
			return 'R';
		}
		else{
			return ' ';
		}
		
	}
	
	
	
	
	
	
}
