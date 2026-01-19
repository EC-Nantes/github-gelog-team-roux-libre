/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;

/**
 *
 * @author vadimdigonnet
 */
public class TestException {
    public static void main(String[] args) {
        World w =new World();
        try {
            String texte = null;
            System.out.println("la longueur du texte est" + texte.length());
        } catch (NullPointerException e) {
            System.out.println("Le texte est null");
        }
        try{
            w.ListeMonstre.get(25).getPos();
        }catch(IndexOutOfBoundsException ex){
            System.out.println("pas assez d'element dans liste objet !!!!!");
        }
        try{
            int a=0;
            int b= 82;
            System.out.println(b/a);
        }catch(ArithmeticException e){
            System.out.println("erreur arithmetique");
        }
        try {
            Object nombre = 10;
            String texte = (String) nombre; 
            System.out.println(texte);
        } catch (ClassCastException e) {
            System.out.println("Erreur de type");
        }
        try {
            String texte = "abc";
            int nombre = Integer.parseInt(texte); 
            System.out.println("Le nombre est : " + nombre);
        } catch (NumberFormatException e) {
            System.out.println("erreur dans la conversion de la chaine de caractere");
        }
    }
}