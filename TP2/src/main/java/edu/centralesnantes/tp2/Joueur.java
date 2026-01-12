/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author vadimdigonnet
 */
public class Joueur {
    ArrayList<Objet> Inventaire = new ArrayList<>();

    /**
     *Permet au joueur de choisir son personnage entre un guerrier et un archer et le nom de celui-ci.
     * @return Le joueur choisi par le personnage.
     */
    public Personnage persoJoueur(){
        System.out.println("Veuillez choisir un personnage entre Guerrier ou Archer");
        Scanner a = new Scanner(System.in);
        String perso = a.nextLine();
        while (!"Guerrier".equals(perso) && !"Archer".equals(perso)){
        System.out.println("Veuillez choisir un personnage entre Guerrier ou Archer");
        perso = a.nextLine();
        }
        System.out.println("Veuillez choisir un nom pour votre personnage");
        String nom = a.nextLine();
        Random r = new Random();
        if ("Archer".equals(perso)){
            Archer b = new Archer(r.nextInt(10)+10,nom,r.nextInt(100)+50,r.nextInt(10)+10,r.nextInt(5)+5,
                    r.nextInt(40)+60,r.nextInt(40)+10,r.nextInt(5)+5,new Point2D(r.nextInt(50)-25,r.nextInt(50)-25));
            return b;
        }
        else {
            Guerrier b = new Guerrier(nom,r.nextInt(150)+75,r.nextInt(20)+20,r.nextInt(7)+5, 
                    r.nextInt(30)+70,r.nextInt(40)+10,1,new Point2D(r.nextInt(50)-25,r.nextInt(50)-25));
            return b;
        }
         
    }
}
