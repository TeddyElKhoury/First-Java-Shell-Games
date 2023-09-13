package test_javag1.Utilitees;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class MyObject extends Object {

    private Scanner sc = new Scanner(System.in);
    private Boolean flag;
    public char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    // added throws for Admins, not used generally
    public void start() throws FalseEntryException {}

    public String choixMultiples(String[] choixTab, String sujet) {
        do {
            flag = true;
            System.out.println("Choisissez le choix (" + sujet
                    + ") qui vous convient :");
            for (int i = 0; i < choixTab.length; i++) {
                System.out.println((i) + ". " + choixTab[i]);
            }
            int x = sc.nextInt();
            System.out.println();
            try {
                for (int i = 0; i < choixTab.length; i++) {
                    if (x == i) { return choixTab[i]; }
                }
                throw new FalseEntryException();
            } catch (FalseEntryException e) {
                flag = false;
            }
        } while (!flag);
        return null;
    }

    protected Object[] shuffleUniTab(String[] t) {
        // tous les tableaux sont de type Objet
        Random rand = new Random();
        int randomisedIndex;
        String temp;

        for (int i = 0; i < t.length; i++) {
            randomisedIndex = (int) rand.nextInt(t.length);
            temp = t[randomisedIndex];
            t[randomisedIndex] = t[i];
            t[i] = temp;
        } return t;
    }

    public String[][] shuffleDoubleTab(String[][] tt) {
        Random rand = new Random();
        int randomisedIndex;
        String[] temp;

        for (int k = 0; k < tt.length; k++) { shuffleUniTab(tt[k]); }
        for (int l = 0; l < tt.length; l++) {
            randomisedIndex = (int) rand.nextInt(tt.length - 1);
            temp = tt[randomisedIndex];
            tt[randomisedIndex] = tt[l];
            tt[l] = temp;
        } return tt;
    }
    
    public String printOrg2DTab(Object[][] tt) {
        String res = "\n \t";
        for (int i = 0; i < tt[0].length; i++){ res += ((i + 1) + "\t"); }
        res += "\n \t";
        for (int i = 0; i < tt[0].length; i++){ res += "-\t"; }
        
        for (int j = 0; j < tt.length; j++){
            res += ("\n" + (j + 1) + "|");
            for (int k = 0; k < tt[j].length; k++){
                res += ("\t" + tt[j][k]);
            }
        } return (res += "\n");
    }
    public String printOrg2DTab(char[][] tt) {
        String res = "\n \t";
        for (int i = 0; i < tt[0].length; i++){ res += ((i + 1) + "\t"); }
        res += "\n \t";
        for (int i = 0; i < tt[0].length; i++){ res += "-\t"; }
        
        for (int j = 0; j < tt.length; j++){
            res += ("\n" + (j + 1) + "|");
            for (int k = 0; k < tt[j].length; k++){
                res += ("\t" + tt[j][k]);
            }
        } return (res += "\n");
    }
}
