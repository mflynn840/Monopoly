import java.util.Scanner;


public class Main {


    public static void main(String[] args){

        Gameboard gameboard = new Gameboard(2);
        

        Scanner sc = new Scanner(System.in);

        int x = 0;
        while(x < 5){

            gameboard.playTurn();
            x++;

        }





    }
    
}
