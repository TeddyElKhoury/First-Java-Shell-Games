package test_javag1.Utilitees;

import java.util.Scanner;
import test_javag1.Jeux.*;
import test_javag1.Utilitees.*;

public class Admins extends MyObject {

    protected static Scanner alpha = new Scanner(System.in);
    private static String name = "root";
    private static String pass = "0000";
    private boolean flag;
    private static ModifArrLst<MyObject> tsJeux = new ModifArrLst<MyObject>();
    
    public Admins() {
        tsJeux.add(new JusteNombre());
        tsJeux.add(new BateauxCaches());
        tsJeux.add(new NombresCaches());
    }

    public String toString() {
        return "Admin Page";
    }

    public void start() throws FalseEntryException {
        do {
            try {
                flag = login();
                ClearS.cls();
            } catch (FalseEntryException e) {
                flag = false;
            }
        } while (!flag);
        do{
            try{
                flag = true;
                choixAdmin();
            } catch (FalseEntryException e){
                System.out.print("Voulez-vous vraiment quiter le menu Admins "
                        + "? (o/n)");
                char c = alpha.next().charAt(0);
                if(c != 'o') flag = false;
            }
        } while (!flag);
        ClearS.cls();
        System.out.println("Press ENTER to go back to Menu...");
        String nothing = alpha.nextLine();
        Menu.start();
        System.exit(-1);
    }

    public static Boolean login() throws FalseEntryException {
        System.out.print("\nVous etes sur le point de vous authentifier,"
                + " voulez vous continuer ? (o/n) > ");
        char c = alpha.next().charAt(0);
        if (c == 'o') {
            System.out.print("\nEntrez votre Identifiant Admin: ");
            String s = alpha.next();
            System.out.print("Entrez votre Mot de Passe Admin: ");
            String ss = alpha.next();
            if (!(s.equals(name) && ss.equals(pass))) {
                throw new FalseEntryException();
            }
            return true;
        }
        System.exit(0);
        return null;
    }

    public void choixAdmin() throws FalseEntryException {
        System.out.println("\n======\t======\n"
                + "1. Ajouter un jeu"
                + "\n2. Supprimer un jeu"
                + "\nA. Pour quitter le menu entrez n'importe quel charactère"
                + "\n======\t======\n");
        System.out.println("Veuillez entrer votre choix : ");
        char s = alpha.next().charAt(0);
        if (s == '1'){
            ajouterUnJeu();
        }else if (s == '2'){
            supprimerUnJeu();
        } else {
            throw new FalseEntryException();
        }
    }
    
    private void ajouterUnJeu(){
        System.out.println("Choisir un jeu a ajouter au menu joueur :");
        System.out.print(tsJeux.toString());
        int chx = alpha.nextInt();
        if(chx >= tsJeux.size()){System.exit(-1);}
        for(int k = 0; k < Menu.listeJ.size(); k++){
            if(Menu.listeJ.get(k).toString().equals(tsJeux.get(chx).toString())){
                System.out.println("Ce jeu existe déjà dans le menu joueur");
                flag = false;
                break;
            }
        } if(flag){
            Menu.listeJ.add(tsJeux.get(chx));
            System.out.println("Le jeu a bien été ajouté !");
        }
    }
    
    private void supprimerUnJeu(){
        System.out.println("Choisir un jeu a supprimer au menu joueur :");
        System.out.print(tsJeux.toString());
        int chx = alpha.nextInt();
        if(chx >= tsJeux.size()){System.exit(-1);}
        for(int k = 0; k < Menu.listeJ.size(); k++){
            if(Menu.listeJ.get(k).toString().equals(tsJeux.get(chx).toString())){
                Menu.listeJ.remove(Menu.listeJ.getNum(tsJeux.get(chx)));
                System.out.println("Le jeu a bien été supprimé !");
                flag = false;
                break;
            }
        } if(flag){
            System.out.println("Ce jeu n'existe pas dans le menu joueur");
        }
    }
}
