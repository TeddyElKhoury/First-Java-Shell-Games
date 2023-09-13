package test_javag1.Utilitees;

import java.io.IOException;

public class ClearS {

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }
}
