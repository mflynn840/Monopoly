import java.io.File;

public class Gamespace {


    //abstract concept: we need to think about what all spaces on the monopoly board share
    
    File pictureOfSpace;
    int position;
    String name;
    
    int relativeBoardPosition;


    //this creates a gamespace
    public Gamespace(String name, int position){

        this.name = name;
        this.position = position;

    }

    public Gamespace(){}


    @Override
    public String toString(){

        return  this.name + " @ " + this.position;

    }
    

    //2 types: properties and event spaces

        //3 pillars OOP:
          //Inheritence
            //defines an "is a" relationship

            //if X is a Y then X extends Y.....
    
    
}

class PropertySpace extends Gamespace{

    //Event e;

    boolean isOwned = false;
    public int price;

    public PropertySpace(String name, int position, int price){
        super(name, position);
        this.price = price;
    
    }

    public String toString(){
        return super.toString() + "($" + this.price + ")";
    }

    public boolean isOwned(){
        return this.isOwned;
    }


}

class EventSpace extends Gamespace{

    //Event e;
    public EventSpace(String name, int position){super(name, position);}

    public String toString(){
        return super.toString() + " (Event)";
    }


}


