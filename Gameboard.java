import java.util.List;
import java.util.Scanner;

public class Gameboard {


    Player[] players;
    Player current;
    int currentIndex = 0;

    Gamespace[] gamespaces;
    public final int numberOfSpaces = 40;


    int currPosition = 0;

    public Gameboard(int numPlayers){

        this.gamespaces = new Gamespace[numberOfSpaces];
        setupBoard();

        this.players = new Player[numPlayers];

        for(int i = 0; i<numPlayers; i++){
            Player p = new Player("Player" + i, 500);
            this.players[i] = p;
        }

        this.current = this.players[this.currentIndex];


    }

    public void playTurn(){

        System.out.println(current);
        Die d1 = new Die();
        Die d2 = new Die();

        int roll1 = d1.roll();
        int roll2 = d2.roll();

        int spacesToMove = roll1+roll2;

        System.out.println("I rolled a: " + spacesToMove);


        this.current.currentSpace = (this.current.currentSpace + spacesToMove) % numberOfSpaces;
        this.currPosition = this.current.currentSpace;
        this.printCurrentSpace();

        Scanner sc = new Scanner(System.in);
        
        if(this.gamespaces[this.currPosition] instanceof PropertySpace){
            if(!((PropertySpace)this.gamespaces[this.currPosition]).isOwned()){

                System.out.println("Would you like to buy this or auction it? (1-buy/0-auction)");

                if(sc.nextInt() == 1){

                    this.current.purchase(this.gamespaces[this.currPosition]);
                }
            }
        }


        if(this.currentIndex == 1){
            this.current = this.players[0];
            this.currentIndex = 0;
        }else{
            this.current = this.players[1];
            this.currentIndex = 1;
        }

        

        
            
    }

    public void printCurrentSpace(){
        System.out.println(this.gamespaces[this.currPosition]);
    }




    public void setupBoard(){
        String[] spaceNames = {"Go", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax"
        ,"Reading Railroad", "Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", 
        "Jail / Just Visiting","St. Charles Place","Electric Company"
        ,"States Avenue","Virginia Avenue","Pennsylvania Railroad","St. James Place" ,"Community Chest" 
        ,"Tennessee Avenue" ,"New York Avenue" ,"Free Parking" ,"Kentucky Avenue" ,"Chance" ,"Indiana Avenue" 
        ,"Illinois Avenue" , "B. & O. Railroad" , "Atlantic Avenue" ,"Ventnor Avenue" ,"Water Works" ,"Marvin Gardens"
        ,"Go To Jail" ,"Pacific Avenue" ,"North Carolina Avenue" ,"Community Chest" ,"Pennsylvania Avenue" ,"Short Line"
        ,"Chance" ,"Park Place" ,"Luxury Tax" ,"Boardwalk"};

        int[] prices = {60, 60, 200, 100, 100, 120, 140, 150, 140, 160, 200, 180, 180, 200, 220, 220, 240, 200, 260, 260, 150, 280, 300, 300, 320, 200, 350, 400};
        

        String[] eventSpaces = {"Go", "Income Tax", "Chance", "Free Parking", "Community Chest", "Luxury Tax", "Jail / Just Visiting", "Go To Jail"};


        int position = 0;

        Gamespace temp = new Gamespace();

        int priceIndex = 0;
        for(String spaceName: spaceNames){
            if(arrayContains(eventSpaces, spaceName)){
                temp = new EventSpace(spaceName, position);
                //System.out.println(temp.name);
            }else{
                temp = new PropertySpace(spaceName, position, prices[priceIndex]);
                priceIndex++;
                
                
            }

            gamespaces[position] = temp;
            position++;
        
        }
    }


    public void printBoard(){
        for(Gamespace gp: this.gamespaces){
            System.out.println(gp);
        }
    }

    public boolean arrayContains(String[] arr, String e){
        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals(e)){
                return true;
            }
        }
        return false;
    }


    
}
