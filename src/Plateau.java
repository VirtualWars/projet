import java.util.Random;


public class Plateau {
	private Cell [] [] plat ;
	private int largeur;
	private int longueur;
	
	public Plateau(int ligne,int colone,int pourcentage){  //initialisation des obstacles 
		largeur = colone;
		longueur = ligne;
		Random r = new Random();
		plat=new Cell [ligne][colone];

		for (int i = 0; i < plat.length; i++) {
			for (int j = 0; j < plat[i].length; j++) {
				if( r.nextInt(100) < pourcentage ){
					if( r.nextInt(100) < 50 ){
						plat[i][j]= new Rocher(i,j);
					}
					else{plat[i][j]= new Arbre(i,j);}
				}
				else{
					plat[i][j] = new Herbe(i,j);
				}
			}
		}
		// On cherche un chemin vers les deux base , si il n'existe pas on le crée
		drawLineLand(0,0,longueur,largeur);
		
		// Déclaration de l'emplacement des bases
		plat[0][0]= new Base(0,0);
		plat[ligne-1][colone-1]= new Base(longueur-1,largeur-1);

		// On initialise les cases autour des base en herbe
		plat[ligne-1][colone-2]= new Herbe(longueur-1,largeur-2);
		plat[ligne-2][colone-1]= new Herbe(longueur-2,largeur-1);
		plat[ligne-2][colone-2]= new Herbe(longueur-2,largeur-2);
		plat[0][1]= new Herbe(0,1);
		plat[1][0]= new Herbe(1,0);
		
		
	}
	
	// On affiche le plateau
	public String toString(){
		String res = "";
			for(int i = 0 ;i<(plat.length*2)+1;i++){
				for(int j =0;j<(plat[2].length*2)+1;j++){
					if(j%2==0 && i%2==0 ){
						res += new String("+");
					}
					if(i%2==1 && j%2==0){
						res += new String("|");
					}					
					if(i%2==1 && j%2==1){
						if((i==1 && j==1) || (i==plat.length*2-1  && j==plat[2].length*2-1)){
							res += " "+plat[i/2][j/2].getRepresentation()+" ";
							
						}
						else{
							res += " "+(plat[i/2][j/2]).getRepresentation()+" ";
						}
					}
					if(i%2==0 && j%2==1){
						res += new String("---");
					}
				}
				res+= "\n";
			}
			return res;
	}
	

	
		// Méthode pour trouvé et crée le chemin 
	public void drawLineLand(int x1, int y1, int x2, int y2) {
		// Bresenham's
		boolean steep = Math.abs(y2 - y1) > Math.abs(x2 - x1);
		int tmp = x1;
		if (steep) {
			x1 = y1;
			y1 = tmp;

			tmp = x2;
			x2 = y2;
			y2 = tmp;
		}

		if (x1 > x2) {
			x1 = x2;
			x2 = tmp;

			tmp = y1;
			y1 = y2;
			y2 = tmp;
		}

		float dx = x2 - x1;
		float dy = Math.abs(y2 - y1);

		float erreur = dx / 2.0f;
		int ystep = (y1 < y2) ? 1 : -1;
		int y = y1;

		int maxX = x2;

		for (int x = x1; x < maxX; x++) {
			if (steep) {
				changerCell(y, x);
				changerCell(y+1, x);
			}
			else {
				changerCell(x, y);
				changerCell(x, y+1);
			}

			erreur -= dy;
			if (erreur < 0) {
				y += ystep;
				erreur += dx;
			}
		}
	}
	private void changerCell(int x, int y) {
		if (x > 0 && x < longueur
				&& y > 0 && y < largeur
				&& plat[x][y].getRepresentation() != ' '){
			plat[x][y] = new Herbe(x,y);
		}
	}
}


