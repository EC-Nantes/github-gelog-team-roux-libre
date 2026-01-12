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
public abstract class Creature extends ElementDeJeu implements Deplacable{
    private int ptVie;
    private int dagAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;

    
    /**
 * crée une nouvelle créature
 * @param ptvie les points de vie
 * @param degatt les degat du monstre
 * @param ptpar ses points de parades
 * @param pageatt pourcentage de chance d'attaque
 * @param pagepar pourcentage de chance de parade
 * @param pos position du monstre
 */
    public Creature(int ptvie, int degatt, int ptpar, int pageatt, int pagepar, Point2D pos) {
        this.ptVie = ptvie;
        this.dagAtt = degatt;
        this.ptPar = ptpar;
        this.pageAtt = pageatt;
        this.pagePar = pagepar;
        this.pos = new Point2D(pos);
    }
    /**
     * crée une copie d'un monstre
     * @param c creature a copié
     */
    public Creature (Creature c){
        this.ptVie = c.ptVie;
        this.dagAtt = c.dagAtt;
        this.ptPar = c.ptPar;
        this.pageAtt = c.pageAtt;
        this.pagePar = c.pagePar;
        this.pos = new Point2D(c.getPos());
    }
    /**
     * 
     */
    public Creature(){
        this(2,100,10,10,10,new Point2D(5,5));
    }

    /**
     *
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @return
     */
    public int getDagAtt() {
        return dagAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @param dagAtt
     */
    public void setDagAtt(int dagAtt) {
        this.dagAtt = dagAtt;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    @Override
    public void deplace(){
        Random a=new Random();
        int b =a.nextInt(2)-1;
        int c =a.nextInt(2)-1;
        this.pos.translate(b, c); 
    }
    /**
     * Affiche les caractéristiques de la créature.
     */
     public void affiche(){
        System.out.println("                   "+ptVie+" point de vie");
        System.out.println("                   "+dagAtt+" point de dégat");
        System.out.println("                   "+ptPar+" point de parade");
        System.out.println("                   "+pageAtt+" pageatt");
        System.out.println("                   "+pagePar+" pagepar");
        System.out.println("                   "+pos.toString());
    }
}
