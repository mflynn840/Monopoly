import java.util.List;

public class Gameboard {


    Gamespace[] gamespaces;
    public final int numberOfSpaces = 40;


    int currPosition = 0;

    public Gameboard(){

        this.gamespaces = new Gamespace[numberOfSpaces];
        setupBoard();


    }

    public void moveOnBoard(){

        Die d1 = new Die();
        Die d2 = new Die();

        int roll1 = d1.roll();
        int roll2 = d2.roll();

        int spacesToMove = roll1+roll2;

        System.out.println("I rolled a: " + spacesToMove);


        this.currPosition = (this.currPosition + spacesToMove) % this.numberOfSpaces;

        //% 40 = the remainder that is left over when dividing by 40

        //  ->  0-39 % 40 = themselves  PERFECT
        // ->  40%40 = 0
        // ->  41%40 = 1

        
            
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

        int position = 0;

        for(String spaceName: spaceNames){
            Gamespace temp = new Gamespace(spaceName, position);
            gamespaces[position] = temp;
            position++;
        
        }
    }


    public void printBoard(){
        for(Gamespace gp: this.gamespaces){
            System.out.println(gp);
        }
    }


    
}
