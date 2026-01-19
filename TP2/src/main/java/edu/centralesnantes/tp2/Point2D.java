/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class Point2D {
    private int positionx;
    private int positiony;
    
    /**
     *
     */
    public Point2D(){
        positionx = 0;
        positiony=0;
          
    }
    
    /**
     *
     * @param positionx
     * @param positiony
     */
    public Point2D(int positionx, int positiony) {
        this.positionx = positionx;
        this.positiony = positiony;
    }
    
    /**
     *
     * @param p
     */
    public Point2D(Point2D p){
        this.positionx = p.positionx;
        this.positiony = p.positiony;
    }
    
    /**
     *
     * @return
     */
    public int getPositionx() {
        return positionx;
    }

    /**
     *
     * @param positionx
     */
    public void setPositionx(int positionx) {
        this.positionx = positionx;
    }

    /**
     *
     * @return
     */
    public int getPositiony() {
        return positiony;
    }

    /**
     *
     * @param positiony
     */
    public void setPositiony(int positiony) {
        this.positiony = positiony;
    }
   
    /**
     *
     * @param dx
     * @param dy
     */
    public void translate(int dx, int dy){ 
    this.positionx += dx ;
    this.positiony += dy;
   }  

    /**
     *Permet d'afficher le couple x,y indiquant la position.
     * @return Une chaîne de caractère.
     */
    public String toString(){
       String res = "["+positionx+";"+positiony+"]";
       return res;
   }
   /**
    * Calcul de la distance entre le point auquel on applique la méthode et un point a 
    * @param a point2D
    * @return la distance calculée
    */
   public double distance(Point2D a){
       double res = Math.sqrt((a.getPositionx()-this.getPositionx())*(a.getPositionx()-this.getPositionx())+(a.getPositiony()-this.getPositiony())*(a.getPositiony()-this.getPositiony()));
       return res;
   }
   public boolean equals(Point2D a){
       return this.positionx == a.positionx && this.positiony == a.positiony;
   }
       
} 

