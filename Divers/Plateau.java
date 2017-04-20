package Divers;
import java.util.ArrayList;
import java.util.Random;
import Cellule.*;


public class Plateau {
    private Cellule [] [] plat ;
    private ArrayList<Robot> listeRobot = new  ArrayList<Robot>();
    private int largeur;
    private int longueur;
    //private Robot[][] platRobot;
    
    public Plateau(int largeur,int longueur,int pourcentage){  //initialisation des obstacles
        this.largeur = largeur;
        this.longueur = longueur;
        Random r = new Random();
        plat=new Cellule [longueur][largeur];
       
       
        /*for (int i = 0; i < plat.length; i++) {
            for (int j = 0; j < plat[i].length; j++) {
                plat[i][j] = null;
            }
        }*/
        

        for (int i = 0; i < plat.length; i++) {
            for (int j = 0; j < plat[i].length; j++) {
                if( r.nextInt(100) < pourcentage ){
                    if(r.nextBoolean()){
                        plat[i][j] = new Rocher();
                    }
                   /* else if(!plat[i][j].estEau()){
                        plat[i][j] = new Arbre();
                    }*/
                    else{
                    	plat[i][j] = new Arbre();
                    }
                }
                else{
                    plat[i][j] = new Cellule();
                }
            }
        }
        // On cherche un chemin vers les deux base , si il n'existe pas on le crée
        drawLineLand(0,0,longueur,largeur);
        
        

        
        // On initialise les cases autour des base en herbe
        plat[longueur-1][largeur-2] = new Cellule();
        plat[longueur-2][largeur-1] = new Cellule();
        plat[longueur-2][largeur-2] = new Cellule();
        plat[0][1] = new Cellule();
        plat[1][0] = new Cellule();
        
        int eauy = (int) longueur/2;
        for (int i = 0; i < largeur; i++) {
            int moins = 1;
            if(eauy >= (int)(longueur/2)+3){
                moins = -1;
            }
            else if(eauy <= (int)(longueur/2)-3){
                moins = 1;
            }
            else{
                moins = -1;
            }

            eauy = eauy + moins;
            if (i==7 || i == 16) { 
                plat[eauy][i] = new Cellule();
                plat[eauy+1][i] = new Cellule();
            }else{
                plat[eauy][i] = new Eau();
                plat[eauy+1][i] = new Eau();
            }
        }
        plat[0][0] = new Base(1);
        //plat[0][1] = new Base(1);
        plat[longueur-1][largeur-1] = new Base(2);
        plat[longueur-1][largeur-2] = new Base(2);
    
        
    }
    
    public ArrayList<Robot> getListeRobot() {
		return listeRobot;
	}
    /**
     * ajoute un tireur a la coordonne donné selon l'equipe en param
     * @param x
     * @param y
     * @param equipe
     */
    public void ajouterTireur(int x,int y,int equipe,Plateau p){
           listeRobot.add(new Tireur(equipe,x,y,p));
    }
    /**
     * ajoute un piegeur a la coordonne donné selon l'equipe en param
     * @param x
     * @param y
     * @param equipe
     */ 
    public void ajouterPiegeur(int x,int y,int equipe,Plateau p){
    	listeRobot.add(new Piegeur(equipe,x,y,p));
    }
    /**
     * ajoute un char a la coordonne donné selon l'equipe en param
     * @param x
     * @param y
     * @param equipe
     */
    public void ajouterChar(int x,int y,int equipe,Plateau p){
    	listeRobot.add(new Char(equipe,x,y,p));
    }
    
    // On affiche le plateau
    public String toString(){
    	Robot[][] platRobot = new Robot[this.longueur][this.largeur];
    	for (int i = 0; i <listeRobot.size() ; i++) {
    		if(!(listeRobot.get(i).getX() < 0 && listeRobot.get(i).getY() < 0) 
    		&& (!(listeRobot.get(i).getX() == 0 && listeRobot.get(i).getY() == 0))
    		&& (!(listeRobot.get(i).getX() == 0 && listeRobot.get(i).getY() == 1))
    		&& (!(listeRobot.get(i).getX() == largeur-1 && listeRobot.get(i).getY() == longueur-1))){
    			platRobot[listeRobot.get(i).getX()][listeRobot.get(i).getY()] = listeRobot.get(i);
    		}		
		}
    	System.out.print("  ");
    	for(int k=0;k<this.largeur;k++){
    		if(k==0){System.out.print(" ");}
    		if(k>=10 && k%2==0){System.out.print(k + " ");}
    		if((k>=10 && k%2 == 1) || k<10){
    			System.out.print(" " + k +"  ");
    		}
    		
    			
    	}
    	System.out.print("\n");
    	int d=0;
        boolean base=false;
        String res = "";
        for(int i = 0 ;i<(plat.length*2)+1;i++){
        	if(i==1){res+=d+" ";d++;}
        	else if (i%2==1){
        		if(d >= 10){
        			res+=d;
        		}
        		else{
        			res+=d+" ";
        		}
        		d++;
        	}
        	else{ res += "  ";}
            for(int j =0;j<(plat[2].length*2)+1;j++){
	             
            		if(j%2==0 && i%2==0 ){
	                    res += new String("+");
	                }
	                if(i%2==1 && j%2==0 && !base ){
	                    res += new String("|");
	                }
	                if(i%2==1 && j%2==1){
	                    if(platRobot[i/2][j/2] != null){
	                        res += " "+platRobot[i/2][j/2].getRepresentation()+" ";
	                    }else{
	                        if(base){
	                            base = !base;
	                            res+="   ";
	                        }
	                        else if(plat[i/2][j/2].getRepresentation().equals("B")){
	                            base = true;
	                            res += "   "+plat[i/2][j/2].getRepresentation();
	                        }else{
	                            res += " "+plat[i/2][j/2].getRepresentation()+" ";
	                        }
	                        
	                    }
	                }
	                
	                if(i%2==0 && j%2==1){
	                    res += new String("---");
	                }
                //	if (i%2==1 && j%2==1 && platRobot[i%2][j%2] != null) {
                //		res += " "+platRobot[i%2][j%2].getRepresentation()+" ";
                //	}
            }
            res+=  "\n";
        }
        for (Robot r : listeRobot) {
			res += r.getType()+" de l'équipe " + r.getEquipe() + ", coordonnées  ("+r.getC().getX()+","+r.getC().getY()+") : "+r.getEnergie() +" energie(s)\n";
		}
        res += "A : Arbre, R : Rocher, C/c : Char, T/t : Tireur, P/p : Piegeur, ~ : Riviere \n";
        return res;
    }
    
    
    
    /**
     * crée un chemin entre la base de l'equipe 1 et 2 qui ne pourra pas etre recouvert par des obstacles
     * @param x du premier point
     * @param y du premier point
     * @param x du deuxiéme point
     * @param y du deuxiéme point
     */
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
    /**
     * crée une nouvelle cellule dans le plateau
     * @param x
     * @param y
     */
    private void changerCell(int x, int y) {
            if (x > 0 && x < longueur
                && y > 0 && y < largeur){
            plat[x][y] = new Cellule();
        }
    }

	
    //---
    public int getLargeur() {
		return largeur;
	}

	public int getLongueur() {
		return longueur;
	}

	public Cellule[][] getPlat() {
		return plat;
	}
    /**
     * crée une equipe
     * @param c = coordonnee
     * @param equipe
     */
	public void ajouterEquipe(Coordonnee c, int equipe){
		if(estOk(c)){
			plat[c.getX()][c.getY()].setEquipe(equipe);
		}	
	}
    /**
     * detruit une équipe
     * @param c
     */
	public void viderEquipe(Coordonnee c){
		if(estOk(c)){
			plat[c.getX()][c.getY()].setEquipe(0);
		}
	}
	
	
	public boolean estOk(Coordonnee coord){
		return coord.getX()<=longueur && coord.getY()<=largeur;
	}


}