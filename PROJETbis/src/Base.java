
public class Base extends Cellule{

	private int equipe;
	
	
	public Base(int x, int y,int equipe) {
		super(x, y);
		this.setEquipe(equipe);
	}


	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	void viderCase(){
		equipe = 0;
	}

	void DeplacerSur(Robot robot) {
		r.setCoordonnee(super.getC().getX(),super.getC().getY());
		
	}
	void ajoute(int equipe) {
		this.equipe = equipe;		
	}

		
	
}
