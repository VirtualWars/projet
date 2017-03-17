import java.util.List;

public abstract class Robot {

		private int equipe;
		private int energie;
		private Vue vue;
		private Coordonnee c;
		
		
		
		public Robot(int equipe, Vue vue, int x, int y){
			super();
			this.equipe = equipe;
			this.vue = vue;
			this.c = new Coordonnee(x,y);
		}
		public int getEquipe() {
			return equipe;
		}
		public void setCoordonnee(int x , int y){
			c = new Coordonnee(x,y);
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
		public Vue getVue() {
			return vue;
		}
		public void setVue(Vue vue) {
			this.vue = vue;
		}
		public void subitTir(){
			energie -= 4;
		}
		public void subitMine(){
			energie -=5;
		}
		public String toString() {
			return "Robot [equipe=" + equipe + ", energie=" + energie + ", vue=" + vue + ", c=" + c + "]";
		}
		public abstract boolean peutTirer();
		public abstract int getCoupAction();
		public abstract int getCoupDeplacement();
		public abstract int getDegatTir();
		public abstract int getDegatMine();
		public abstract String getType();
		public abstract List<Coordonnee> getDeplacements();

		
		
		
		
}
