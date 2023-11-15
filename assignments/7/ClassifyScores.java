import java.util.Scanner;

/**
** Program Name: Score Storage
** Author: Hossein Toutounchi
** Date: oct 27th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class ClassifyScores
{
	/**
	 * Main method promts the user to enters an score between 0 and 100. As long as they wish
	 * main will terminate if the user enters a negative number it will terminate the program and shows
	 * how many of each grade has been stored. If the user enters anything more than 100 the program will
	 * ignore the user's entry
	 */

	public static void main(String[] args)
	{
	    final int size = 10;
	    int score;
	    Scanner input = new Scanner(System.in);
	    
	    int myGrades[] = new int [size] ;
	    System.out.println("Welcome to score storage program");
	    System.out.println("Score range must be between 0 and 100");
		
		do
		{
			//First we promt the user to enter a grade and continue asking until a negative number is entered

		    System.out.println("Please enter an score");
		    score = input.nextInt() ;

			//If the number entered is valid it will store it in the array of scores.

		    if (verifyScore(score))
		        storeArray(score, myGrades);
		    
		}while(score>=0);
		
		//If the negative number was entered the program displays the array.

	    displayArray(myGrades);
	}
	
	public static boolean verifyScore(int score)
	{
		//This method will find out if the user entered a valid score or not.

	    boolean verify = true;
	    if (score>100)
	    {
	        System.out.println("the score can't be bigger than 100");
	        verify = false;
	    }
	    if (score<0)
	    {
	        System.out.println("The score can't be smaller than zero");
	        verify = false;
	    }
	    return verify;
	}
	
	public static void storeArray(int num, int myGrades[])
	{
		// This method will store the number in the allocated array based on the score entered.

        if (num==100)
            myGrades[9]++;
        else
        {
            int group = num/10;
            myGrades[group]++;
	    }
	}
	
	public static void displayArray (int myGrades[])
	{
		//This method will display the number of scores that was stored in each array.
		
	    System.out.println("  Range         NUMBER OF SCORES");
	    System.out.println("____________________________________");
	    System.out.println(" 0 - 9 " + "                "+ myGrades[0]);
	    for(int i = 19; i<99;i+=10)
	    {
	        int temp= i/10;
	        System.out.println((i-9) + " - " + (i) + "                "+ myGrades[temp]);
	    }  
        System.out.println("90 - 100" + "               "+ myGrades[9]);
	}
	
}
