/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class Objet extends ElementDeJeu {

    /**
     *
     * @param pos Position de l'objet.
     */
    public Objet(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    /**
     *
     * @param b
     */
    public Objet(Objet b){
        this.pos = new Point2D(b.getPos());
    }

    /**
     *
     */
    public Objet(){
        pos.setPositionx(0);
        pos.setPositiony(0);
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
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     *Permet à la créature d'utiliser l'objet.
     * @param C Créature qui utilise l'objet.
     */
    public void utiliser(Creature C){
        
    }
    /**
     * Sauvegarde de l'objet.
     * @return Une ligne de texte avec toutes les caractéristiques de l'objet.
     */
    public String getTexteSauvegarde() {
        return getClass().getSimpleName() + " " + pos.getPositionx() + " " + pos.getPositiony();
    }

}

