/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class Lapin extends Monstre {

    /**
     *
     * @param ptvie
     * @param da
     * @param ppar
     * @param patt
     * @param papar
     * @param p
     */
    public Lapin(int ptvie,int da,int ppar,int patt,int papar,Point2D p){
        super(ptvie,da,ppar,patt,papar,p);
    }
    
    /**
     *
     * @param l
     */
    public Lapin(Lapin l){
        this(l.getPtVie(),l.getDagAtt(),l.getPtPar(),l.getPageAtt(),l.getPagePar(),l.getPos());
    }

    /**
     *
     */
    public Lapin(){
        this(3,1,1,1,1,new Point2D(5,5));
    }
}
