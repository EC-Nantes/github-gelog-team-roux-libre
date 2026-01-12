/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class Epee extends Objet{
    int degat;

    /**
     *
     * @param degat
     * @param pos
     */
    public Epee(int degat, Point2D pos) {
        super(pos);
        this.degat = degat;
    }

    /**
     *
     */
    public Epee(){
        super(new Point2D(5,5));
        degat = 3;
    }
    
    /**
     *Permet d'ajouter des dégats d'attaque au personnage lorsqu'il utilise l'épée.
     * @param c Créature à laquelle on ajoute l'épée.
     */
    public void utiliser(Creature c){
        c.setDagAtt(c.getDagAtt()+degat);
    }

    /**
     *Permet d'afficher les dégats de l'épée.
     * @return Une chaine de caractère indiquant les points de dégats de l'épée.
     */
    public String toString(){
       String res = "Epée avec "+degat+" points de dégats";
       return res;
   }
    @Override
    public String getTexteSauvegarde() {
        return "Epee " + degat + " " + getPos().getPositionx() + " " + getPos().getPositiony();
    }


}