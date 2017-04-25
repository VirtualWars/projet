package Divers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Cellule.Robot;

public class Action {
    
    public static void actionRobot(Robot r,Plateau p){
        boolean dejaAttaquer = false;
        String action = "";
        while(!dejaAttaquer || r.getDeplacement() > 0){
            action = saisieAction(r);
            if (action.equals("Passer au robot suivant")) {
                dejaAttaquer = true;
                r.setDeplacement(-1);
            }else if(action.equals("Attaquer") && r.peutTirer()){
                attaquer(r,p);
            }else if(action.equals("Deplacement")){
                r.deplacement();
            }
            
        }
        r.resetDeplacement();
    }
    
    private static String saisieAction(Robot r){
        Object[] possibleValues = { "Attaquer", "Deplacement", "Passer au robot suivant" };
        String res = (String) JOptionPane.showInputDialog(null,
                "Quelle action veux tu effectuer avec le "+r.getType()+" situé en "+r.getC(), "Choix actions",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
        return res;
    }
    
    private static void attaquer(Robot robot,Plateau p) {
        JFrame frame = new JFrame();
        String[] res;
        res = JOptionPane.showInputDialog(frame,"Entrez une coordonnee ou attaquer").split("/");
        
        while(!testCoordonneeAttaqueValide(res,p)){
            
            res = JOptionPane.showInputDialog(frame,"Entrez une coordonnee ou attaquer").split("/");
            
        }
        
        for (Robot r : p.getListeRobot()) {
            
            if(r.getC().getX()==Integer.valueOf(res[0]) && r.getC().getY()==Integer.valueOf(res[1])){
                
                if ((r.getC().getX() - robot.getC().getX() )<= robot.getPortee() && (r.getC().getX() - robot.getC().getX() )>= robot.getPortee()*(-1) && 
                        (r.getC().getY() - robot.getC().getY() )<= robot.getPortee() && (r.getC().getY() - robot.getC().getY() )>= robot.getPortee()*(-1)) {
                    
                    r.setEnergie(r.getEnergie()-robot.getDegatTir());
                    
                }
                
                
            }
            
        }
        
        robot.getVue().setPlateau(p);
        System.out.println(robot.getVue().getPlateau());
        
    }
    
    public static boolean testCoordonneeAttaqueValide(String[] n,Plateau p){
        if (n.length==2) {
            if (Integer.valueOf(n[0])>=0 && Integer.valueOf(n[0]) <= p.getLargeur() && Integer.valueOf(n[1])>=0 && Integer.valueOf(n[1]) <= p.getLongueur()) {
                return true;
            }
        }
        return false;
        
    }
    
    
}
