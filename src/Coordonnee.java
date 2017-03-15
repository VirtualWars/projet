
public class Coordonnee {

		private int x;
		private int y;
		
		public Coordonnee(int x, int y){
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public String toString() {
			return "Coordonnee [x=" + x + ", y=" + y + "]";
		}
		public void modifierCoordonnee(Coordonnee c){
			this.x = c.getX();
			this.y = c.getY();
		}
}
