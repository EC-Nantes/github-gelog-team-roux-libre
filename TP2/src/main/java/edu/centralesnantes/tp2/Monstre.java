/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public abstract class Monstre extends Creature {  

    /**
     *
     * @param ptvie
     * @param da
     * @param ppar
     * @param patt
     * @param papar
     * @param p
     */
    public Monstre(int ptvie,int da,int ppar,int patt,int papar,Point2D p){
        super(ptvie,da,ppar,patt,papar,p);
    }

    /**
     *
     * @param m
     */
    public Monstre(Monstre m){
        this(m.getPtVie(),m.getDagAtt(),m.getPtPar(),m.getPageAtt(),m.getPagePar(),m.getPos());
    }

    /**
     *
     */
    public Monstre(){
        this(10,1,1,1,1,new Point2D(5,5));
    }
    public void affiche(){
        System.out.print("ce Monstre a");
        super.affiche();
    }
    /**
     * Sauvegarde du monstre.
     * @return Une ligne de texte avec toutes les caractéristiques du monstre.
     */
    public String getTexteSauvegarde() {
        return getClass().getSimpleName() + " " + getPtVie() + " " + getDagAtt() + " " +
           getPtPar() + " " + getPageAtt() + " " + getPagePar() + " " +
           getPos().getPositionx() + " " + getPos().getPositiony();
}

}