import java.util.Scanner;

/**
** Program Name: Exponent Finder
** Author: Hossein Toutounchi
** Date: sep 29th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class ExponentFinder
{
	/**
	 * This program will help the user to find all the integer values that are less 
	 * The number they have entered
	 */

	public static void main(String[] args)
	{
	    int num, xnum;
	    Scanner input = new Scanner(System.in);
	    
		System.out.println("Please enter a number between 1 and 200");
		num = input.nextInt();
		
		// first we need to find out if the user is entering the number within the range

		if (num>200 || num<1)
		{
		    System.out.println("your entry is out of the range ");
			return;
		}
		
		//Then we check for all the numbers to the power of two as long as the numbers are less than the entry

		for (int i= 0; Math.pow(i,2) < num; i++)
		{
		    xnum = (int)Math.pow(i,2);
		    System.out.print(xnum + " ");
		}
	}
}
