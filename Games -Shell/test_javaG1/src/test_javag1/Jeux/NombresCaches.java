package test_javag1.Jeux;

import test_javag1.Utilitees.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class NombresCaches extends MyObject{
    
    private Scanner beta = new Scanner(System.in);
    private Random rand = new Random();
    private int max; // le max de chiffres a entrer
    protected Boolean flag = true;
    private String[] diffi = {"10", "15", "25"}; // les max.s{?
    
    public String toString(){
        return "NombresCachés";
    }
    
    public void start() throws FalseEntryException{
        System.out.println("Bienvenue dans le jeu des " + this.toString() + "!"
                + "\nVous allez devoir mémoriser les nombres qui vous seront "
                + "envoyés sur l'écran\npuis les écrire l'un à la suite de "
                + "l'autre **sans espaces** et cela successivement"
                + "\nExemple : Moi: 1 2 3 > Vous: 123 \n Moi: 4 5 6 > Vous: "
                + "123456\nCliquer sur ENTREE quand vous serez prêt...");
        beta.nextLine();
        ClearS.cls();
        System.out.println("Choix de la difficulté :");
        max = Integer.parseInt(choixMultiples(diffi, "le total des chiffres"));
        
        int[] sorCh = null; // nombre de chiffres de sorties par partie
        switch(max){
            case 10: sorCh = new int[4]; sorCh[0] = 3; sorCh[1] = 2; 
                sorCh[2] = 3; sorCh[3] = 2; break;
            case 15: sorCh = new int[3]; sorCh[0] = 3; sorCh[1] = 5; 
                sorCh[2] = 7; break;
            case 25: sorCh = new int[4]; sorCh[0] = 5; sorCh[1] = 4; 
                sorCh[2] = 6; sorCh[3] = 10; break;
        }
        ClearS.cls();
        System.out.println("\nLe jeu va bientôt commencer...\nCliquer sur "
                + "ENTREE pour le déclancher...");
        beta.nextLine();
        
        // les chiffres entrés par le client
        ArrayList<Integer> chffEn = new ArrayList<Integer>(); 
        // les chiffres sortis par le IA
        ArrayList<Integer> chffSor = new ArrayList<Integer>(); 
        // sequence a utiliser pour assurer la succession des chiffres
        int sequence = 0; 
        // on cherche selon les valeurs du sorCh
        int ln = 0;
        do{
            ClearS.cls();
            System.out.print("\nVoici les chiffres à mémoriser : ");
            for(int i = 0; i < sorCh[ln]; i++){
                // remplir par des int pour faire sortir
                chffSor.add(rand.nextInt(9)); 
                System.out.print(chffSor.get(sequence++) + " ");}
            System.out.println("\nCliquer sur ENTREE pour continuer...");
            beta.nextLine();
            ClearS.cls();
            
            System.out.println("\nEntrer les chiffres mémorisés : ");
            // on lit l'entrée du client par un tableau de chars
            char c[] = beta.nextLine().toCharArray();
            // le client doit entrer les chiffres du tout début ::chffSor.size()
            for(int i = 0; i < chffSor.size(); i++){
                // si un chff ne correspond pas a celui du IA, le client perd
                if(chffSor.get(i) != Integer.parseInt(c[i] + "")){ 
                    System.out.println("Vous avez entré un faux chiffre : "
                            + c[i] + " qui devait être : " + chffSor.get(i));
                    flag = false; }
            } if(flag){ 
                System.out.println("Vous avez entré les bons chiffres ! "
                        + "\nCliquer sur ENTREE pour continuer !");
                beta.nextLine(); }
        }while(flag && ++ln < sorCh.length);
        
        ClearS.cls();
        System.out.println("You have finished the game !"
                + "Press Enter to go back to Menu...");
        beta.nextLine();
        Menu.start();
        System.exit(-1);
    }
    
}
