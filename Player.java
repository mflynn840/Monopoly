import java.util.ArrayList;

public class Player {

    int money;
    String name;
    int currentSpace;

    ArrayList<PropertySpace> owned;

    public Player(String name, int money){
        this.name = name;
        this.money = money;
        this.currentSpace = 0;
        this.owned = new ArrayList<PropertySpace>();
    }

    public String toString(){
        return this.name + " $" + this.money;
    }

    public void purchase(Gamespace p){

        this.owned.add((PropertySpace)p);
        this.money -= ((PropertySpace)p).price;

    }
    
}
