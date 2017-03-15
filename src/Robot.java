
public class Robot {
	private int equipe = 0;
	private int energie;
	private Coordonnee c;
	
	
	
	
	public void setCoordonnee(Coordonnee c){
		this.c = c;
	}
	
	public Coordonnee getCoordonnee() {
		return c;
	}

	public Robot(int x,int y,int equipe,int energie){
		this.equipe = equipe;
		this.energie = energie;
		c = new Coordonnee(x, y);
	}

	public int getEquipe() {
		return equipe;
	}
	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}
	public int getEnergie() {
		return energie;
	}
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	
}
