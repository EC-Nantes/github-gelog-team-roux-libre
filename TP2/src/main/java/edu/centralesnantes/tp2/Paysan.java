/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class Paysan extends Personnage{
    
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
    public Paysan(String nom, int ptVie, int dagAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, dagAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
    }
   
    /**
     *
     * @param a
     */
    public Paysan(Paysan a){
        this(a.getNom(),a.getPtVie(),a.getDagAtt(),a.getPtPar(),a.getPageAtt(),a.getPagePar(),a.getDistAttMax(),a.getPos());
    }
    
    /**
     *
     */
    public Paysan(){
        this("default",50,10,5,5,5,20,new Point2D(0,0));
    }
}
