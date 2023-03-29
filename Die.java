import java.util.Random;

public class Die {


    int value;


    public Die(){

    }

    public int roll(){
        Random r1 = new Random();
        return r1.nextInt(6) + 1;

        
    }
    
}
