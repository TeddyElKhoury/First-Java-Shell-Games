package test_javag1.Utilitees;

import java.util.ArrayList;
import java.util.Scanner;
import test_javag1.Jeux.*;

public class Menu {

    private static boolean flag;
    protected static Scanner alpha = new Scanner(System.in);
    public static ModifArrLst<MyObject> listeJ = new ModifArrLst<MyObject>();
        
    public Menu() throws FalseEntryException {
        listeJ.add(new Admins());
        listeJ.add(new JusteNombre());
        listeJ.add(new BateauxCaches());
        listeJ.add(new NombresCaches());
        start();
    }
    
    public static void start(){
        ClearS.cls();
        do {
            flag = false;
            try {
                choix().start();
            } catch (FalseEntryException e) {
                flag = true;
                ClearS.cls();
            }
        } while (flag);
    }
    
    // type MyObject pour pouvoir user de la methode start()
    protected static MyObject choix() throws FalseEntryException {
        System.out.print("\nChoisir le numero du jeu voulu : "
                + listeJ.toString());
        int chx = alpha.nextInt();
        if(chx >= listeJ.size() || chx < 0){
            throw new FalseEntryException();
        }
        ClearS.cls();
        return listeJ.get(chx);
    }

}
