package twenty.one;

/*
 * The Die class simulates a six-sided die.
 */
import java.util.Random;
/**
 *
 * @author TaylorJenkins
 */
public class Die 
{
    private final int SIDES = 6; //Number of sides
    private int value; //The die's value
	
    /*Constructor performs the first roll of the die. 
     @param numSides The number of sides for the die.
    */
    public Die()
    {
            roll();
    }

    /**The roll method simulates the rolling of the die. 
     * 
     */
    public void roll()
    {
            //create random object.
            Random rand = new Random();

            //get random value for the die.
            value = rand.nextInt(SIDES) +1;
    }

    /**
     * getValue method
     * @return The value of the die
     */
    public int getValue()
    {
            return value;
    }
}
