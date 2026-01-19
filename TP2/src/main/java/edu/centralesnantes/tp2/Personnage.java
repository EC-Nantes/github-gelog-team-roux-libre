/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;
/**
 *
 * @author vadimdigonnet
 */
public abstract class Personnage extends Creature{

    private String nom;
    private int distAttMax;

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
    public Personnage(String nom, int ptVie, int dagAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(ptVie,dagAtt,ptPar,pageAtt,pagePar,pos);
        this.nom = nom;
        this.distAttMax = distAttMax;
    }

    /**
     *
     * @param l
     */
    public Personnage(Personnage l){
        this(l.nom,l.getPtVie(),l.getDagAtt(),l.getPtPar(),l.getPageAtt(),l.getPagePar(),l.distAttMax,l.getPos());
    }
    /**
     *
     */
    public Personnage(){
        this("default",10,2,2,2,2,2,new Point2D(5,5));

    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

  
    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }



    @Override
    public void affiche(){
        System.out.println("Les attribut du personnage sont :    Nom :"+nom);
        System.out.println("                                     distAttMax : "+distAttMax);
        super.affiche();
    }
    /**
     * Sauvegarde du personnage.
     * @return Une ligne de texte avec toutes les caractéristiques du personnage.
     */
    public String getTexteSauvegarde() {
        return getClass().getSimpleName() + " " + nom + " " + getPtVie() + " " + getDagAtt() + " " +
           getPtPar() + " " + getPageAtt() + " " + getPagePar() + " " + distAttMax + " " +
           getPos().getPositionx() + " " + getPos().getPositiony();
}


}
