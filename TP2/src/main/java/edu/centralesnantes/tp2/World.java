/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.centralesnantes.tp2;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author vadimdigonnet
 */
public class World {
    ArrayList<Personnage> ListePerso= new ArrayList<>();
    ArrayList<Monstre> ListeMonstre= new ArrayList<>();
    ArrayList<Objet> ListeObjet= new ArrayList<>();
    Joueur j = new Joueur();
    Personnage pj;
    int haut = 50;
    int larg=50;
    int arret = 0;


    /**
     *Constructeur d'un monde avec un nombre aléatoire de chaque type compris entre 0 et 10.
     */
    public World() {
        Random a = new Random();
        for(int i =0;i<a.nextInt(10)+10;i++){
            ListePerso.add(new Archer());
        }
        for(int i =0;i<a.nextInt(10)+10;i++){
            ListePerso.add(new Paysan());
        }
        for(int i =0;i<a.nextInt(10)+10;i++){
            ListeMonstre.add(new Lapin());
        }
        for(int i =0;i<a.nextInt(10)+10;i++){
            ListePerso.add(new Guerrier());
        }
        for(int i =0;i<a.nextInt(10)+10;i++){
            ListeMonstre.add(new Loup());
        }
        for(int i =0;i<a.nextInt(10)+10;i++){
            ListeObjet.add(new Epee());
        }
        for(int i =0;i<a.nextInt(10)+10;i++){
            ListeObjet.add(new PotionSoin());
        }
        
    }
    
    /**
     *Crée un Monde aléatoire en plaçant les protagonistes et objets sur des cases aléatoires toutes différentes les unes des autres.
     */
    public void creerMondeAlea() {
        Random b = new Random();
        int x;
        int y;
        pj = j.persoJoueur();
        for(Personnage p : ListePerso){
            x = b.nextInt(50)-25;
            y = b.nextInt(50)-25;
            while(this.caseOccupe(new Point2D(x,y))!=0){
                x = b.nextInt(50)-25;
                y = b.nextInt(50)-25;
            }
            p.getPos().setPositionx(x);
            p.getPos().setPositiony(y);
                      
        }
        for(Monstre p : ListeMonstre){
            x = b.nextInt(50)-25;
            y = b.nextInt(50)-25;
            while(this.caseOccupe(new Point2D(x,y))!=0){
                x = b.nextInt(50)-25;
                y = b.nextInt(50)-25;
            }
            p.getPos().setPositionx(x);
            p.getPos().setPositiony(y);
        }
        for(Objet p : ListeObjet){
            x = b.nextInt(50)-25;
            y = b.nextInt(50)-25;
            while(this.caseOccupe(new Point2D(x,y))!=0){
                x = b.nextInt(50)-25;
                y = b.nextInt(50)-25;
            }
            p.getPos().setPositionx(x);
            p.getPos().setPositiony(y);
        }

        
    }
    
    /**
     *Nous indique si la case est occupée ou non.
     * @param a case que l'on veut tester 
     * @return 0 si la case est libre, 1 si elle est occupée par une créature, 2 si elle est occuppée par un objet
     */
    public int caseOccupe(Point2D a){
        int b =0;
        for (Personnage p : ListePerso){
            if (p.getPos().equals(a)){
                b=1;
            }
        }    
        for (Monstre m : ListeMonstre){
            if (m.getPos().equals(a)){
                b=1;
            }
        
        }
        for (Objet c : ListeObjet){
            if (c.getPos().equals(a)){
                b=2;
            }
        
        }
        return b;
        
    }

    /**
     *Affiche les cases de chaque élément de notre monde.
     */
    public void affichePoseElement(){
        for (Personnage p : ListePerso){
            System.out.println("position : "+p.getPos());
        }
        for (Monstre p : ListeMonstre){
            System.out.println("position : "+p.getPos());
        }
        for (Objet p : ListeObjet){
            System.out.println("position : "+p.getPos());
        }

    }
    
    /**
     * Fait un tour de jeu, d'abord le joueur joue puis les créatures se déplacent et combattent de manière aléatoire.
     */
    public void tourDeJeu(){
        Scanner s = new Scanner(System.in);
        System.out.println("Combattre : 1 ; Se déplacer : 2 ; Utiliser un objet : 3 ; Sauvegarder : 4" );
        String choix = s.nextLine();
        while (!"1".equals(choix) && !"2".equals(choix) && !"3".equals(choix) && !"4".equals(choix)){
        System.out.println("Combattre : 1 ; Se déplacer : 2 ; Utiliser un objet : 3 ; sauvegarder : 4");
        choix = s.nextLine();
        }
        if ("4".equals(choix)) {
            System.out.println("Nom du fichier de sauvegarde ");
            String nomFichier = s.nextLine()+".txt";
            sauvegardePartie(nomFichier);
            System.out.println("Voulez-vous continuer la partie ? (oui/non)");
            String rep = s.nextLine();
            if ("non".equals(rep)) {
                System.out.println("Fin de la partie.");
                arret = 1;
                return; 
            } else {
                System.out.println("Reprise du tour !");
            }
        }
        if ("2".equals(choix)){
            int b =1;
            while (b == 1){
                System.out.println("De combien de cases voulez-vous vous déplacez horizontalement? (max 3, min -3)");
                String vertical = s.nextLine();
                int vert = Integer.parseInt(vertical);
                while ((vert>3) || (vert<-3)){
                    System.out.println("De combien de cases voulez-vous vous déplacez horizontalement? (max 3, min -3)");
                    vertical = s.nextLine();
                    vert = Integer.parseInt(vertical);                
                }
                System.out.println("De combien de cases voulez-vous vous déplacez verticalement? (max 3, min -3)");
                String horizontal = s.nextLine();
                int hor = Integer.parseInt(horizontal);
                while ((hor>3) || (hor<-3)){
                    System.out.println("De combien de cases voulez-vous vous déplacez verticalement? (max 3, min -3)");
                    horizontal = s.nextLine();
                    hor = Integer.parseInt(horizontal);
                }
                Point2D p = new Point2D(pj.getPos());
                p.translate(hor, vert);
                b = this.caseOccupe(p);
                if (b==1){
                    System.out.println("Cette case est déja occupée");
                }
                else{
           
                    pj.setPos(p);
                }               
            }
            b = caseOccupe(pj.getPos());
            if (b == 2){
                for(int i=0; i< ListeObjet.size();i++){
                    if (ListeObjet.get(i).getPos().equals(pj.getPos())){
                        j.Inventaire.add(ListeObjet.get(i));
                        ListeObjet.remove(i);
                    }
                }
            }
            
            
        }else if("3".equals(choix)){
            if (j.Inventaire.size()!=0){
                    System.out.println("Votre inventaire il y a :");
                for (int i=0;i < j.Inventaire.size();i++){
                    System.out.println(i+" : "+j.Inventaire.get(i));
                }
                System.out.println("Choisis le numéro de l'objet que tu veux utiliser");
                String choix2 = s.nextLine();         
                while(Integer.parseInt(choix2)>=j.Inventaire.size()){
                    System.out.println("Objet non utilisable");
                    choix2 = s.nextLine();
                }
                int chx2 = Integer.parseInt(choix2);
                j.Inventaire.get(chx2).utiliser(pj);
                j.Inventaire.remove(chx2);
            }else{
                System.out.println("Votre inventaire est vide");
            }
            
        }else if(pj instanceof Combattant){
            Creature c = this.adversaireProche(pj);
            ((Combattant)pj).combattre(c);
            System.out.println("vous avez attaquez "+c.getClass().getSimpleName()+"Il lui reste "+c.getPtVie()+"PV");
            
        }
        for (Personnage p : ListePerso){
            if (p instanceof Combattant){
                Creature c = adversaireProche(p);
                if (p.getPos().distance(c.getPos())<=p.getDistAttMax()){
                    ((Combattant) p).combattre(c);
                }else{
                    deplacePnj(p);
                }
                
            }else{
                deplacePnj(p);
            }           
        }
        for (Monstre p : ListeMonstre){
            if (p instanceof Combattant){
                Creature c = adversaireProche(p);
                if (p.getPos().distance(c.getPos())<=1){
                    ((Combattant) p).combattre(c);
                }else{
                    deplacePnj(p);
                }
                
            }else{
                deplacePnj(p);                
            }
        }
        for (int i = 0;i<ListeMonstre.size();i++){
            if (ListeMonstre.get(i).getPtVie() <= 0){
                ListeMonstre.remove(i);
                }
        }
        for (int i = 0;i<ListePerso.size();i++){
            if (ListePerso.get(i).getPtVie() <= 0){
                ListePerso.remove(i);
                }
        }
        afficheWorld();
           
    }
    
    /**
     *Déplace un PNJ de manière aléatoire entre -1 et 1 et vertical et en horizontal, sans aller sur des cases déjà occupées.
     * @param c Créature que l'on veut déplacer.
     */
    public void deplacePnj(Creature c){
        Random a=new Random();
        boolean t = false;
        while(t==false){
            Point2D p0 = new Point2D(c.getPos());        
            int b =a.nextInt(2)-1;
            int d =a.nextInt(2)-1;
            int x = c.getPos().getPositionx();
            int y = c.getPos().getPositiony();
            Point2D p = new Point2D(b+x,d+y);
            if (this.caseOccupe(p) != 1 || p.equals(p0)){
               c.setPos(p);
               t = true;
            }
        }
    }

    /**
     *Cherche l'adversaire le plus proche de la créature c.
     * @param c Créature dont on cherche l'adversaire le plus proche.
     * @return La créature la plus proche.
     */
    public Creature adversaireProche(Creature c){
        Creature pro = new Paysan("rfrf",0,0,0,0,0,0,new Point2D(2000,2000));
        for (Personnage p : ListePerso){
            if (p !=c && (pro.getPos().distance(c.getPos())>p.getPos().distance(c.getPos())) && (pro.getPos().distance(c.getPos())!=p.getPos().distance(c.getPos())) ){
                pro = p;
            }
        }
        for (Monstre p : ListeMonstre){
            if (p!=c && (pro.getPos().distance(c.getPos())>p.getPos().distance(c.getPos())) && (pro.getPos().distance(c.getPos())!=p.getPos().distance(c.getPos()))){
                pro = p;
            }
        }
        if (pj!=c &&(pro.getPos().distance(c.getPos())>pj.getPos().distance(c.getPos())) && (pro.getPos().distance(c.getPos())!=pj.getPos().distance(c.getPos()))){
                pro = pj;
            }
        return pro;
    }
    /**
     *  Crée une interface graphique sous forme de matrice pour indiquer la position des protagonistes et des objets.
     */
    public void afficheWorld (){
        String[][] monde = new String[50][50];
        Point2D a =new Point2D();
        for (int i=0;i<50;i++){
            for( int j=0; j<50;j++){
                monde[i][j]=". ";
            }
        }
        for (Personnage p : ListePerso){
            a=p.getPos();
            int x =a.getPositionx()+25;
            int y =a.getPositiony()+25;
            if (x>=0 && x<=50 && y>=0 && y<=50){
                if ("Guerrier".equals(p.getClass().getSimpleName())){
                    monde[x][y]="G ";
                }
                if ("Archer".equals(p.getClass().getSimpleName())){
                    monde[x][y]="A ";
                }
                if ("Paysan".equals(p.getClass().getSimpleName())){
                    monde[x][y]="P ";
                }
            }    
        }
        for (Monstre p : ListeMonstre){
            a=p.getPos();
            int x =a.getPositionx()+25;
            int y =a.getPositiony()+25;
            if (x>=0 && x<=50 && y>=0 && y<=50){
                if ("Lapin".equals(p.getClass().getSimpleName())){
                    monde[x][y]="R ";
                }
                if ("Loup".equals(p.getClass().getSimpleName())){
                    monde[x][y]="L ";
                }
            }
        }
        for (Objet p : ListeObjet){
            a=p.getPos();
            int x =a.getPositionx()+25;
            int y =a.getPositiony()+25;
            if (x>=0 && x<=50 && y>=0 && y<=50){
                if ("Epee".equals(p.getClass().getSimpleName())){
                    monde[x][y]="E ";
                }
                if ("PotionSoin".equals(p.getClass().getSimpleName())){
                    monde[x][y]="S ";
                }
            }
        }
        a=this.pj.getPos();
        int x = a.getPositionx()+25;
        int y = a.getPositiony()+25;
        if (x>0 && x<=50 && y>=0 && y<=50){
               monde[x][y]="J ";
            }
        for (int i=0;i<50;i++){
            System.out.println(Arrays.toString(monde[i]));
        }
        System.out.println("J : Joueur, L : Loup, R : Lapin, P : Paysan, G : Guerrier, A : Archer, E : Epee, S : Potion");
    }
    
        /**
     * Sauvegarde l'état du monde et du joueur dans un fichier texte.
     * @param nomFichier le nom du fichier texte 
     */
    public void sauvegardePartie(String nomFichier) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {

            writer.write("Largeur "+larg);
            writer.newLine();
            writer.write("Hauteur "+haut);
            writer.newLine();

            for (Personnage p : ListePerso) {
                writer.write(p.getTexteSauvegarde());
                writer.newLine();
            }
            for (Monstre m : ListeMonstre) {
                writer.write(m.getTexteSauvegarde());
                writer.newLine();
            }
            for (Objet o : ListeObjet) {
                writer.write(o.getTexteSauvegarde());
                writer.newLine();
            }
            writer.write("Joueur " + pj.getTexteSauvegarde());
            writer.newLine();
            for (Objet o : j.Inventaire) {
                writer.write("Inventaire " + o.getTexteSauvegarde());
                writer.newLine();
            }
            System.out.println("Sauvegarde réussie dans " + nomFichier);
        } catch (IOException e) {
            System.err.println("Erreur de sauvegarde : " + e.getMessage());
        }
    }
    /**
    * Charge une partie à partir d’un fichier texte (format WoE)
    * @param nomFichier le nom du fichier de sauvegarde
    */
   public void chargementPartie(String nomFichier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            ListePerso.clear();
            ListeMonstre.clear();
            ListeObjet.clear();
            j.Inventaire.clear();

            while ((ligne = reader.readLine()) != null) {
               String[] t = ligne.split(" ");
               String type = t[0];

                switch (type) {
                    case "Largeur":
                        break;
                    case "Hauteur":
                        break;
                    case "Guerrier":
                       ListePerso.add(new Guerrier(t[1],
                               Integer.parseInt(t[2]), Integer.parseInt(t[3]),
                               Integer.parseInt(t[4]), Integer.parseInt(t[5]),
                               Integer.parseInt(t[6]), Integer.parseInt(t[7]),
                               new Point2D(Integer.parseInt(t[8]), Integer.parseInt(t[9]))));
                        break;
                    case "Archer":
                       ListePerso.add(new Archer(Integer.parseInt(t[10]), t[1],
                               Integer.parseInt(t[2]), Integer.parseInt(t[3]),
                               Integer.parseInt(t[4]), Integer.parseInt(t[5]),
                               Integer.parseInt(t[6]), Integer.parseInt(t[7]),
                               new Point2D(Integer.parseInt(t[8]), Integer.parseInt(t[9]))));
                        break;
                    case "Paysan":
                       ListePerso.add(new Paysan(t[1],
                               Integer.parseInt(t[2]), Integer.parseInt(t[3]),
                               Integer.parseInt(t[4]), Integer.parseInt(t[5]),
                               Integer.parseInt(t[6]), Integer.parseInt(t[7]),
                               new Point2D(Integer.parseInt(t[8]), Integer.parseInt(t[9]))));
                        break;
                    case "Loup":
                       ListeMonstre.add(new Loup(
                               Integer.parseInt(t[1]), Integer.parseInt(t[2]),
                               Integer.parseInt(t[3]), Integer.parseInt(t[4]),
                               Integer.parseInt(t[5]),
                               new Point2D(Integer.parseInt(t[6]), Integer.parseInt(t[7]))));
                        break;
                    case "Lapin":
                       ListeMonstre.add(new Lapin(
                               Integer.parseInt(t[1]), Integer.parseInt(t[2]),
                               Integer.parseInt(t[3]), Integer.parseInt(t[4]),
                               Integer.parseInt(t[5]),
                               new Point2D(Integer.parseInt(t[6]), Integer.parseInt(t[7]))));
                        break;
                    case "Epee":
                       ListeObjet.add(new Epee(Integer.parseInt(t[1]),
                               new Point2D(Integer.parseInt(t[2]), Integer.parseInt(t[3]))));
                        break;
                    case "PotionSoin":
                       ListeObjet.add(new PotionSoin(Integer.parseInt(t[1]),
                               new Point2D(Integer.parseInt(t[2]), Integer.parseInt(t[3]))));
                        break;
                    case "Joueur":
                        pj = new Guerrier(t[2],
                               Integer.parseInt(t[3]), Integer.parseInt(t[4]),
                               Integer.parseInt(t[5]), Integer.parseInt(t[6]),
                               Integer.parseInt(t[7]), Integer.parseInt(t[8]),
                               new Point2D(Integer.parseInt(t[9]), Integer.parseInt(t[10])));
                        break;
                    case "Inventaire":
                        if (t[1].equals("Epee")) {
                             j.Inventaire.add(new Epee(Integer.parseInt(t[2]),
                                   new Point2D(Integer.parseInt(t[3]), Integer.parseInt(t[4]))));
                        } else if (t[1].equals("PotionSoin")) {
                            j.Inventaire.add(new PotionSoin(Integer.parseInt(t[2]),
                                   new Point2D(Integer.parseInt(t[3]), Integer.parseInt(t[4]))));
                        }
                        break;
                  
               }
           }           
       } catch (IOException e){
           System.err.println("Erreur de chargement : " + e.getMessage());
       }
   }



}
