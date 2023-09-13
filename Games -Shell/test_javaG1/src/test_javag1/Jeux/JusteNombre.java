package test_javag1.Jeux;

import test_javag1.Utilitees.*;
import java.util.Random;
import java.util.Scanner;

public class JusteNombre extends MyObject{
    
    private Scanner beta = new Scanner(System.in);
    private boolean flag;
    private int mode, intervalle;
    private Random rand = new Random();
    
    public String toString(){
        return "JusteNombre";
    }
    
    // throws FEE for memu start();
    public void start() throws FalseEntryException{
        System.out.println("\n====\t====\nBienvenue dans le jeu du "
                + "JusteNombre !\nVous devriez choisir d'abord le mode de jeu,"
                + "\npuis, un intervalle de jeu\npuis, selon la demande, "
                + "entrer le nombre estimé comme juste\n====\t====\n");
        
        String[] c1 = {"9999999","25","8","3"};
        mode = Integer.parseInt(choixMultiples(c1, "vies"));
        String[] c2 = {"100","250","450","500","800","1000","1500","2500"};
        intervalle = Integer.parseInt(choixMultiples(c2,"Max de l'intervalle"));
        
        System.out.println("\n\n======\t======\nVoilà que le jeu commence.."
                + "\nPatientez quelques minutes SVP..."
                + "\n\nAttention, le jeu se déroulera entre 0 et " 
                + intervalle + " !");
        int nbr = rand.nextInt(intervalle - 0)+ 0;
        
        System.out.print("Quel nombre estimez-vous être le JN ? > ");
        int en = beta.nextInt();
        
        while(mode > 0){
            if(mode == 0){
                System.out.println("Vous avez perdu avec 0 points de vie !"
                        + "\nLe Juste Nombre était : " + nbr + " !");
                break;
            }
            
            if(en < nbr){
                System.out.print("Plus GRAND encore ! "
                        + "(Points de vie : " + --mode +") > ");
                en = beta.nextInt();
            }
            else if(en > nbr){
                System.out.print("Encore plus PETIT ! > "
                        + "(Points de vie : " + --mode +") > ");
                en = beta.nextInt();
            }
            else {
                System.out.println("Bien Joué ! le Juste Nombre était : "
                    + nbr + " !\nIl vous restait " + mode
                    + " Points de vie !");
                break;
            }
        }
        System.out.println("Press ENTER to go back to Menu...");
        beta.nextLine();
        Menu.start();
        System.exit(-1);
    }
}
