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
public class Loup extends Monstre implements Combattant{

    /**
     *
     * @param ptvie
     * @param da
     * @param ppar
     * @param patt
     * @param papar
     * @param p
     */
    public Loup(int ptvie,int da,int ppar,int patt,int papar,Point2D p){
        super(ptvie,da,ppar,patt,papar,p);
    }
    
    /**
     *
     * @param l
     */
    public Loup(Loup l){
        this(l.getPtVie(),l.getDagAtt(),l.getPtPar(),l.getPageAtt(),l.getPagePar(),l.getPos());
    }

    /**
     *
     */
    public Loup(){
        this(10,3,3,3,3,new Point2D(10,10));
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
