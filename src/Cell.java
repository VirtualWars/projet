
public class Cell{
	
		private char representation = ' ';
		private Coordonnee coord;
		private boolean herbe = false;
		private boolean rocher = false;
		private boolean arbre = false;
		private boolean  base = false;
		
		Cell(int x,int y){
			coord = new Coordonnee(x,y);
			herbe = true;
		}
		
		public Coordonnee getCoordonnee(){
			return coord;
		}
		public char getRepresentation(){
			return representation;
		}

		public String toString(){
			return "";
		}
		public void setToHerbe(){
			herbe = true;
			rocher = false;
			arbre = false;
			base = false;
			representation = ' ';
		}
		public void setToRocher(){
			herbe = false;
			rocher = true;
			arbre = false;
			base = false;
			representation = 'R';
		}
		public void setToArbre(){
			herbe = false;
			rocher = false;
			arbre = true;
			base = false;
			representation = 'A';
		}
		public void setTobase(){
			herbe = false;
			rocher = false;
			arbre = false;
			base = true;
			representation = 'B';
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
		public boolean estBase(){
			return base;
		}
}
