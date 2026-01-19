package edu.centralesnantes.tp2;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vadimdigonnet
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        World w = new World();
        Scanner s = new Scanner(System.in);
        System.out.println("Voulez vous charger une partie existante ? (oui/non)");
        String r = s.nextLine();
        if (r.equals("oui")){
            System.out.println("Nom du fichier de sauvegarde que vous voulez lancer ");
            String nomFichier = s.nextLine();
            w.chargementPartie(nomFichier+".txt");
        }else{    
            w.creerMondeAlea();
        }
        w.afficheWorld();
        while (w.arret == 0){
                w.tourDeJeu();
                if (w.pj.getPtVie()<=0){
                    System.out.println("VOUS ÊTES MORT"); 
                    break;            
                }
        }   
    }    
        
        
          
}
    

