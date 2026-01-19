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
public class Guerrier extends Personnage implements Combattant{
    
    /**
     *
     * @param nom
     * @param ptVie
     * @param dagAtt
     * @param ptPar
     * @param pageAtt
     * @param pagePar
     * @param distAttMax
     * @param pos
     */
    public Guerrier(String nom, int ptVie, int dagAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, dagAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
    }
   
    /**
     *
     * @param a
     */
    public Guerrier(Guerrier a){
        this(a.getNom(),a.getPtVie(),a.getDagAtt(),a.getPtPar(),a.getPageAtt(),a.getPagePar(),a.getDistAttMax(),a.getPos());
    }
    
    /**
     *
     */
    public Guerrier(){
        this("Guerrier",50,20,5,75,20,1,new Point2D(0,0));
    }

    @Override
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
        }
    }
}