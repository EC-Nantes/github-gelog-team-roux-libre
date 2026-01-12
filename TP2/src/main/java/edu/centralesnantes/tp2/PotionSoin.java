/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class PotionSoin extends Objet{
    int soin;

    /**
     *
     * @param soin
     * @param pos
     */
    public PotionSoin(int soin, Point2D pos) {
        super(pos);
        this.soin = soin;
    }

    /**
     *
     */
    public PotionSoin(){
        this(20,new Point2D(5,5));
    }

    /**
     *
     * @return
     */
    public int getSoin() {
        return soin;
    }

    /**
     *
     * @param soin
     */
    public void setSoin(int soin) {
        this.soin = soin;
    }
    /**
     *Permet d'ajouter des points de vie au personnage lorsqu'il utilise la potion.
     * @param c Créature à laquelle on ajoute les PV.
     */
    public void utiliser(Creature c){
        c.setPtVie(c.getPtVie()+this.soin);
    }

    /**
     *Permet d'afficher les PV de la potion.
     * @return Une chaine de caractère indiquant les points de soin de la potion.
     */
    public String toString(){
       String res = "Potion de "+soin+" points de soin";
       return res;
    }
    @Override
    public String getTexteSauvegarde() {
        return "PotionSoin " + soin + " " + getPos().getPositionx() + " " + getPos().getPositiony();
    }

}
