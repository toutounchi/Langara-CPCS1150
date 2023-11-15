import java.util.Scanner;

/**
** Program Name: Words in sentence Calculator
** Author: Hossein Toutounchi
** Date: oct 13th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class DayOfWeek
{
	public static void main(String[] args)
	{
		/**
		 * This program will find the fist day of the year based on zeller's algorithm
		 */

	    int year, dayOfWeek;
	    Scanner input = new Scanner(System.in);

		System.out.println("Please enter a year greater than 1582:");
		year = input.nextInt();
		
		//We verify the user's entry

		if (verifyYear(year))
		{
			//We envoke the method to capture the zeller and then put it into weekDay to get the coresponding day.

		    dayOfWeek = zeller(1,1,year);
		    System.out.println("The first day of January " + year + " is on " + weekDay(dayOfWeek));
		}
	}
	
	public static boolean verifyYear(int year)
	{
		/**
		 * This method will check the entry of the user to be more than 1582.
		 */

	    boolean verification = true;
	    if (year<1582)
	    {
	        System.out.println("Year you have entered in smaller than 1582");
	        verification = false;
	    }
	    return verification;
	}
	public static int zeller(int day, int month, int year)
	{
		/**
		 * This method calculates the zeller's number based on the year that the user enters.
		 * note: this program assumes the month and day is 1.
		 */

	    int startYear, startDay, startMonth, leapFactor, zeller;
	    if (month<3)
	    {
	        startMonth = 0;
	        startYear = year -1;
	    }
	    
	    else
	    {
	        startMonth = (int) (0.4 * month + 2.3);
	        startYear = year;
	    }
	    
        leapFactor = (startYear/4) - (startYear/100) + (startYear/400);
        zeller = ((365 * year + 31 * (month - 1) + day + leapFactor - startMonth) - 1)%7;
        return zeller;
	}
	
	public static String weekDay (int num)
	{
		/**
		 * This method will convert the zeller's number to the day of the week.
		 * each number represents one day of the week from 0-6.
		 */

	   String weekDay = "";
	   switch (num)
        {
            case 0:
                weekDay = "Sunday";
                break;
                
            case 1:
                weekDay = "Monday";
                break;
                
            case 2:
                weekDay = "Tuesday";
                break;
                
            case 3:
                weekDay = "Wednesday";
                break;
                
            case 4:
                weekDay = "Thursday";
                break;
                
            case 5:
                weekDay = "Friday";
                break;
                
            case 6:
                weekDay = "Saturday";
                break;
        }
        return weekDay;
	}
}
