/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;
import java.util.Random;

/**
 *
 * @author vadimdigonnet
 */
public class Archer extends Personnage implements Combattant{
    
    private int nbFleches;

    /**
     *
     * @param nbFleches 
     * @param nom
     * @param ptVie
     * @param dagAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param distAttMax
     * @param pos
     */
    public Archer(int nbFleches, String nom, int ptVie, int dagAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, dagAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
        this.nbFleches = nbFleches;
    }
   
    /**
     *
     * @param a 
     */
    public Archer(Archer a){
        this(a.nbFleches,a.getNom(),a.getPtVie(),a.getDagAtt(),a.getPtPar(),a.getPageAtt(),a.getPagePar(),a.getDistAttMax(),a.getPos());
    }

    /**
     *
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     *
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }
    
    
    /**
     *
     */
    public Archer(){
        this(10,"Archer",50,10,5,65,20,20,new Point2D(0,0));
    }
    
    public void affiche(){
        super.affiche();
        System.out.println("                                     nbFleches : "+nbFleches);
    }
    /**
     *Combat la créature C, en fonction de ses caractéristique et de la distance qui les séparent.
     * @param c Créature que l'on souhaite combattre
     */
    public void combattre(Creature c){
        Random a = new Random();
        if(this.getPos().distance(c.getPos())==1){
            if(a.nextInt(100) <= getPageAtt()){
                if(a.nextInt(100) > c.getPagePar()){
                    c.setPtVie(c.getPtVie()-this.getDagAtt());               
                }
                else{
                    if(c.getPtPar() <= this.getDagAtt()){
                        c.setPtVie(c.getPtVie()-this.getDagAtt()+c.getPtPar());
                    }
                }
            }
            
            else if(this.getPos().distance(c.getPos()) <= this.getDistAttMax()){
                if (nbFleches > 0){                   
                    nbFleches -= 1;
                    if(a.nextInt(100) <= getPageAtt()){
                       c.setPtVie(c.getPtVie()-this.getDagAtt());                        
                    }
                }
            }   
        }
    }
    
    @Override
    public String getTexteSauvegarde() {
        return "Archer " + getNom() + " " + getPtVie() + " " + getDagAtt() + " " +
           getPtPar() + " " + getPageAtt() + " " + getPagePar() + " " +
           getDistAttMax() + " " + getPos().getPositionx() + " " + getPos().getPositiony() +
           " " + nbFleches;
    }

}
