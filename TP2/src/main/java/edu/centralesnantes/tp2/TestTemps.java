/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;
import java.util.ArrayList;

/**
 *
 * @author vadimdigonnet
 */
public class TestTemps {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        ArrayList<Personnage> l= new ArrayList<>();
        for(int i=0;i<1000;i++){
            l.add(i, new Archer());
        }
        int s = 0;
        long debut = System.nanoTime();
        for(int i =0 ; i<1000;i++){
            s+=l.get(i).getPtVie();
        }
        long fin = System.nanoTime();
        System.out.println( "Pour un ArrayList, boucle basée sur la taille le temps est de " + (fin-debut));
        int s2 = 0;
        long debut2 = System.nanoTime();
        for(Personnage p : l){
            s2+=p.getPtVie();
        }
        long fin2 = System.nanoTime();
        System.out.println("Pour un Arraylist, boucle basée sur les itérateurs le temps est de " + (fin2-debut2));
        System.out.println("La somme des poitns de vie des personnages est de "+s2);
    }
}