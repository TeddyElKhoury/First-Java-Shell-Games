package tictactoegameshell;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    
    protected Scanner beta = new Scanner(System.in);
    protected Random rand = new Random();
    private char uSymb, aiSymb; // USER-SYMBOL ; AI-SYMBOL ;
    private int sequence = 0; // sequence number of who's turn 
    private char[] map = {'1','2','3','4','5','6','7','8','9'};

public void start() throws FalseEntryException{
    toggleUserChoice();
    toggleAIChoice();
    startGame();
    continueGame();
}
private char toggleUserChoice() throws FalseEntryException{
    ClearS.cls();
    System.out.println("Bienvenue au jeu de TicTacToe ! Vous devriez "
        + "commencer par choisir votre symbole !\n Entrer un symbole (X, 0) > ");
    boolean flag;
    char c = 'N'; // the user choice
    do{
        try{
            flag = false;
            c  = beta.next().charAt(0);
            if(!(c == 'X' || c == '0')){throw new FalseEntryException();}
        }catch(FalseEntryException e){
            System.out.println("Vous devriez entrer un symbole de type"
                + " X (iks) ou 0 (zero) > ");
            flag = true;
        }
    }while(flag);
    return this.uSymb = c;
}
private char toggleAIChoice() throws FalseEntryException{
    if(this.uSymb == 'X'){return this.aiSymb = '0';}
    else{return this.aiSymb = 'X';}
}

private void startGame() throws FalseEntryException{
    if(this.uSymb == 'X'){startAIGame(); this.sequence++;}
    else{startUGame(); this.sequence++;}
}
private void continueGame() throws FalseEntryException{
    while(this.sequence < 9){
        checkWin();
        if(this.uSymb == '0'){
            if(this.sequence % 2 == 0){
                startUGame();
                sequence++;
            } else{
                startAIGame();
                sequence++;
            }
        } else{
            if(this.sequence % 2 == 0){
                startAIGame();
                sequence++;
            } else{
                startUGame();
                sequence++;
            }
        }
    }
    checkWin();
    GameFinished();
}
private void GameFinished(){
    ClearS.cls();
    System.out.println("Le jeu est finit !");
    printMap();
    System.out.println("Entrer pour quiter le jeu !");
    beta.next();
    System.exit(0);
}
private void checkWin(){
    if(map[0] == map [1] && map[0] == map[2]){GameFinished();}
    if(map[3] == map [4] && map[3] == map[5]){GameFinished();}
    if(map[6] == map [7] && map[6] == map[8]){GameFinished();}

    if(map[0] == map [3] && map[0] == map[6]){GameFinished();}
    if(map[1] == map [4] && map[1] == map[7]){GameFinished();}
    if(map[2] == map [5] && map[2] == map[8]){GameFinished();}

    if(map[0] == map [4] && map[0] == map[8]){GameFinished();}
    if(map[2] == map [4] && map[2] == map[6]){GameFinished();}
}

private void startAIGame(){
    boolean flag;
    do{
        flag = false;
        int i = rand.nextInt(8 - 0 + 1) + 0; // ((max-min) + 1)  + min;
        if(i < 0 || i > 9 || map[i] == 'X' || map[i] == '0'){flag = true;}
        else{map[i] = aiSymb;}
    }while(flag);
}
private void startUGame() throws FalseEntryException{
    ClearS.cls();
    printMap();
    boolean flag;
    do{
        try{
            flag = false;
            System.out.println("Choisissez une case vide (N) de numéro 1 à 9");
            int a = beta.nextInt();
            if(a < 0 || a > 9 || map[a-1] == 'X' || map[a-1] == '0'){
                throw new FalseEntryException(); 
            }else{ map[a-1] = uSymb; }
        }catch(FalseEntryException e){
            flag = true;
            System.out.println("Attention !!");
        }
    }while(flag);
}

private void printMap(){
    String res = " " + map[0] + " | " + map[1] + " | " + map[2];
    res += "\n----------\n";
    res += " " + map[3] + " | " + map[4] + " | " + map[5];
    res += "\n----------\n";
    res += " " + map[6] + " | " + map[7] + " | " + map[8];
    System.out.println(res);
}

}
