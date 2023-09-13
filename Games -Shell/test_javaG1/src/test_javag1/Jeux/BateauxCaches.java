package test_javag1.Jeux;

import test_javag1.Utilitees.*;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class BateauxCaches extends MyObject {
    
    private Scanner beta = new Scanner(System.in);
    private int mode;
    private int[] data = new int[4];
    private String[][] carte;

    public String toString() {
        return "BateauxCachés";
    }
    
    // throws FEE for memu start();
    public void start() throws FalseEntryException{
        System.out.println("\n======\t======\n"
                + "Bienvenue dans le jeu BateauxCachés !"
                + "\nVous devriez choisir d'abord le mode de jeu,"
                + "\npuis, selon la carte (map) déployée, choisir la *Cellule* "
                + "que vous désirez révéler."
                + "\nA chaque bonne estimation, vous gagnez 1 point, pour deux "
                + "estimations justes seccesives (ou plus), vous en-gagnez 2 !"
                + "\n======\t======\n");
        
        String[] chxMode = {"25","49","81"};
        mode = Integer.parseInt(choixMultiples(chxMode, "Nombre de Cellules"));
        int tabType = (int) (Math.sqrt(mode));
        
        carte = new String[tabType][tabType];
        for(String[] a : carte){ Arrays.fill(a, "0"); }
        String[][] prototypeCarte = new String[tabType][tabType];
        for(String[] t : prototypeCarte){ Arrays.fill(t, "0"); }
        
        switch(tabType){
            // data : 0-> nbrEntrées. 1-> nbrCoeurs. 2-> score. 3-> nbrDes"1"
            case 5 : data[0] = 17; data[1] = 9; data[3] = 8;
                // j'ai du ajouter les "0" puisque le split supprime tout le tab
                carte[0] = "11100".split(""); carte[3][0] = "10000";
                carte[1] = carte[2] = "11000".split(""); 
                shuffleDoubleTab(carte); break;
            case 7 : data[0] = 32; data[1] = 17; data[3] = 15;
                carte[0] = "1111100".split(""); carte[3] = "1100000".split(""); 
                carte[1] = carte[2] = "1110000".split(""); 
                carte[4] = carte[5] = "1000000".split(""); 
                shuffleDoubleTab(carte); break;
            case 9 : data[0] = 52; data[1] = 25; data[3] = 27;
                carte[0] = "111111000".split(""); 
                carte[1] = "111110000".split("");
                carte[2] = carte[3] = "111100000".split(""); 
                carte[4] = carte[5] = "111000000".split(""); 
                carte[6] = "110000000".split("");
                shuffleDoubleTab(carte); break;
            default : System.exit(-1);
        } 
        
        System.out.println("\nVous êtes sur le point de commencer, "
                + "veuillez patienter quelques instants...\n"
                + "Bienvenue dans la carte [" + tabType + "x" + tabType + "] "
                + "\nVous allez pouvoir commencer par choisir une cellule...");
        
        int seqSucces = 0, chxCol, chxLi;
        while(true){
            System.out.println("!\nVoici la map :\n" 
                + printOrg2DTab(prototypeCarte)
                + "\nVoici les données de jeu : \nEntrées : " 
                + data[0] + "\tVie : " + data[1] + "\tFragments : " + data[3]
                + "\tScore : " + data[2]);
            
            while(true){
                System.out.print("\nEntrer le *Numero* de la *Ligne* > ");
                chxLi = beta.nextInt() - 1;
                if (chxLi >= 0 && chxLi < carte.length) {break;} 
            }
            while(true){
                System.out.print("\nEntrer le *Numero* de la *Colone* > ");
                chxCol = beta.nextInt() - 1;
                if (chxLi >= 0 && chxLi < carte[0].length) {break;} 
            }
            switch(carte[chxLi][chxCol]){
                case "1" : if(seqSucces == 1){++data[2];}; 
                        --data[0]; ++data[2]; --data[3]; seqSucces = 1;
                        prototypeCarte[chxLi][chxCol] = "1"; ClearS.cls();
                        /* mettre le break ici pour que la carte s'affiche de 
                        toute facon quand le client recommence son choix*/
                        break;
                case "0" : --data[0]; --data[1]; seqSucces = 0;
                        prototypeCarte[chxLi][chxCol] = "x"; ClearS.cls();
                        break;
                default : System.exit(-1);
            }
            
            if(data[1] == 0){
                ClearS.cls();
                System.out.println("Vous avez perdu ! voici les deux cartes :"
                        + "\nVotre jeu : " + printOrg2DTab(prototypeCarte)
                        + "\nLa carte révélée : " + printOrg2DTab(carte)
                        + "\nIl vous restait " + data[3] + "Fragments de "
                        + "bateau à trouver !");
                break;
            }
            if(data[3] == 0){
                ClearS.cls();
                System.out.println("Vous avez Gagné la partie avec un score"
                        + "de " + data[2] + " !\nBravo !"
                        + "\nRedirection vers le Menu, veuillez patienter..."
                        + "\n=== Cliquer sur ENTREE ===");
                beta.nextLine();
                break;
            }
        }
        System.out.println("Press ENTER to go back to Menu...");
        beta.nextLine();
        Menu.start();
        System.exit(-1);
    }
}
