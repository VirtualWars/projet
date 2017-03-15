
public class Cell{
	
		
		private int x; 
		private int y;
		private boolean herbe;
		private boolean rocher;
		private boolean arbre;
		private int test;
		
		Cell(int x,int y){
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public String toString(){
			return "";
		}
		public void setToHerbe(){
			herbe = true;
			rocher = false;
			arbre = false;
		}
		public void setToRocher(){
			herbe = false;
			rocher = true;
			arbre = false;
		}
		public void setToArbre(){
			herbe = false;
			rocher = false;
			arbre = true;
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
		
		public char getRepresentation(){
		//	Color c = new Color(0, 169, 0);
			
		// On cherche quoi mettre comme caractére pour la représentation.
			
			if(herbe){return ' ';}
			if(rocher){return 'R';}
			if(arbre){return 'A';}
			return 'B';
			
		}
}
