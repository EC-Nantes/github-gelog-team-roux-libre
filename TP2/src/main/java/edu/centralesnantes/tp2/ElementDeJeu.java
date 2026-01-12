/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class ElementDeJeu {
    Point2D pos;

    public ElementDeJeu(Point2D pos) {
        this.pos = pos;
    }

    public ElementDeJeu() {
        this.pos=new Point2D(15,15);
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
}