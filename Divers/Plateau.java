package Divers;
import java.util.ArrayList;
import java.util.Random;
import Cellule.*;


public class Plateau {
    private Cellule [] [] plat ;
    ArrayList<Robot> listeRobot = new  ArrayList<Robot>();
    private int largeur;
    private int longueur;
    //private Robot[][] platRobot;
    
    public Plateau(int largeur,int longueur,int pourcentage){  //initialisation des obstacles
        this.largeur = largeur;
        this.longueur = longueur;
        Random r = new Random();
        plat=new Cellule [largeur][longueur];
       
       
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
        plat[largeur-1][longueur-2] = new Cellule();
        plat[largeur-2][longueur-1] = new Cellule();
        plat[largeur-2][longueur-2] = new Cellule();
        plat[0][1] = new Cellule();
        plat[1][0] = new Cellule();
     // Déclaration de l'emplacement des bases
        plat[0][0] = new Base(1);
        plat[0][1] = new Base(1);
        plat[largeur-1][longueur-1] = new Base(2);
        plat[largeur-1][longueur-2] = new Base(2);
        
        int eauy = plat.length/2;
        for (int i = 0; i < plat[1].length; i++) {
            int moins = 1;
            if (r.nextBoolean()) {
                moins = -1;
            }
            if(eauy >= 6){
                moins = -1;
            }
            if(eauy <= 3){
                moins = 1;
            }
            eauy = eauy + moins;
            if (i==7 || i == 16) {
                plat[eauy][i] = new Cellule();
                plat[eauy-1][i] = new Cellule();
            }else{
                plat[eauy][i] = new Eau();
                plat[eauy-1][i] = new Eau();
            }
        }
    
        
    }
    
    public void ajouterTireur(int x,int y,int equipe){
           listeRobot.add(new Tireur(x,y,equipe));
    }
    
    // On affiche le plateau
    public String toString(){
    	Robot[][] platRobot = new Robot[this.longueur][this.largeur];
    	for (int i = 0; i <listeRobot.size() ; i++) {
    		if(!(listeRobot.get(i).getX() < 0 || listeRobot.get(i).getY() < 0)){
    			platRobot[listeRobot.get(i).getX()][listeRobot.get(i).getY()] = listeRobot.get(i);
    		}		
		}
    	
        boolean base=false;
        String res = "";
        for(int i = 0 ;i<(plat.length*2)+1;i++){
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
                        else if(plat[i/2][j/2].getRepresentation()=='B'){
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
                && y > 0 && y < largeur){
            plat[x][y] = new Cellule();
        }
    }
    
}