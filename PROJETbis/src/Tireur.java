import java.util.List;

public class Tireur extends Robot{

	private static int deplacement;
	private static int coutAction;
	private static int coutDeplc;
	private static int degatTir;
	private static int degatMine = 0;
	private static char representation = 'T';
	
	/*public void setDeplcament(int deplacement){
		this.deplacement = deplacement;
	}*/
	public static int getDeplacement() {
		return deplacement;
	}
	public int getCoutAction() {
		return coutAction;
	}
	public int getCoutDeplacement() {
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
	public Tireur(int equipe, int x, int y) {
		super(equipe, x, y);
	}
	
	public boolean peutTirer(){
		return super.getEnergie() >= 2;
	}
	@Override
	public List<Coordonnee> getDeplacements() {
		// TODO Auto-generated method stub
		return null;
	}
	public char getRepresentation() {
		return representation;
	}
}
