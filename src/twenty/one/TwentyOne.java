/*
 * This program lets the user play against the computer in a variation of the 
 * popular blackjack card game. In this variation of the game, two six-sided 
 * dice are used instead of cards. The dice are rolled, and the player tries 
 * to beat the computer's hidden total without going over 21.
 */
package twenty.one;

import java.util.Scanner;

/**
 *
 * @author TaylorJenkins
 */
public class TwentyOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
	int computerPoints = 0;
        int userPoints = 0;
        int choice = getUserChoice();
   
        while (choice == 1)
        {
            computerPoints += getRollValue();
            userPoints += getRollValue();
            
            //break in loop if either go over 21
            if(!isNotBust(userPoints) || !isNotBust(computerPoints))
            {
                break;
            }
            
            System.out.println("User Points: " + userPoints);
            choice = getUserChoice();
        }
        
        if (userPoints == 0 && computerPoints == 0)
        {
            System.out.println("You cannot win if you do not play.");
        }
        else
        {
            displayResults(computerPoints,userPoints);
        }
    }
    
    /**
    * getUserChoice method
    * @return whether the user wants to continue to roll the die or not.
    */
    public static int getUserChoice()
    {
        int userChoice;
        int rollAgain = 0;
                
        Scanner keyboard = new Scanner(System.in);
	System.out.print("Would like to roll the die? 1) Yes or 2) No ");
	userChoice = keyboard.nextInt();
		
        switch (userChoice) 
        {
            case 1:
                rollAgain = 1;
                break;
            case 2:
                System.out.println("...");
                break;
            default:
                System.out.println("ERROR: Invalid Input. System Exiting.");
                System.exit(0);
        }
        
        return rollAgain;
    }
    
    /**
     * Method should add the sum of the both die values.
     * @return integer sum value
     */
    public static int getRollValue()
    {
        Die die = new Die();
        
        //roll first die
        int roll1Value = die.getValue();
        //roll second die
        int roll2Value = die.getValue();
        
        //return the sum of the rolled values
        return roll1Value + roll2Value;
    }
    
    
    /**
     * Method will determine if either player has hit 21
     * @param value
     * @return true if value is less than 21
     */
    public static boolean isNotBust(int value) 
    {
        if (value > 21)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * This will return a message of the results of the winner.
     * @param computerScore
     * @param userScore
     * @return String identifying the winner.
     */
    public static String getWinnerMessage(int computerScore, int userScore)
    {
        if (userScore > computerScore && isNotBust(userScore))
        {
            return "Congratulations, You are the winner!";
        }
        else if (isNotBust(userScore) && !isNotBust(computerScore))
        {
            return "Congratulations, You are the winner!";
        }
        else if (userScore == 21 && computerScore != 21)
        {
            return "Congratulations, You are the winner!";
        }
        else if (userScore == computerScore)
        {
            return "The game was a tie.";
        }
        else if (!isNotBust(userScore) && !isNotBust(computerScore))
        {
            return "The game was a draw.";
        }
        else
        {
            return "Sorry, better luck next time.";
        }
    }
    
    /**
     * Displays the points to the user.
     * @param computerScore
     * @param userScore 
     */
    public static void displayResults(int computerScore, int userScore)
    {
        //Display the computer and user's points
        System.out.println("\n GAME OVER \n");
        System.out.println("User's Points: " + userScore);
        System.out.println("Computer's Points: " + computerScore);
        
        System.out.println(getWinnerMessage(computerScore, userScore));
    }
    
}
