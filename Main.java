public class Main {


    public static void main(String[] args){

        Gameboard gameboard = new Gameboard();
        
        gameboard.printCurrentSpace();

        while(true){
            System.out.println("I am about to roll the dice");
            gameboard.moveOnBoard();
            gameboard.printCurrentSpace();
        }





    }
    
}
