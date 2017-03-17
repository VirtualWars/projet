
public abstract class Tireur extends Robot{

	private static int deplacement;
	private static int coutAction;
	private static int coutDeplc;
	private static int degatTir;
	private static int degatMine = 0;
	
	/*public void setDeplcament(int deplacement){
		this.deplacement = deplacement;
	}*/
	public static int getDeplacement() {
		return deplacement;
	}
	public static int getCoutAction() {
		return coutAction;
	}
	public static int getCoutDeplc() {
		return coutDeplc;
	}
	public int getDegatTir() {
		return degatTir;
	}
	public int getDegatMine() {
		return degatMine;
	}
	public String getType(){
		return "tireur";
	}
	public Tireur(int equipe, Vue vue, int x, int y) {
		super(equipe, vue, x, y);
	}
	
	public boolean peutTirer(){
		return super.getEnergie() >= 2;
	}
	
}
