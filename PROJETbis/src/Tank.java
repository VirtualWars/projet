public abstract class  Tank extends Robot{
    
    	private static int deplacement;
	private static int coutAction;
	private static int coutDeplc;
	private static int degatTir;
	private static int degatObus = 0;
        
        public Tank(int equipe, Vue vue, int x, int y) {
		super(equipe, vue, x, y);
	}
        
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
	public int getDegatObus() {
		return degatObus;
	}
	public String getType(){
		return "tank";
	}
        public boolean peutTirer(){
		return super.getEnergie() >= 4;
	}
        public boolean peutTirerobus(){
		return super.getEnergie() >= 7;
	}
    
}
