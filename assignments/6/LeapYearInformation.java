import java.util.Scanner;

/**
** Program Name: Leap Year Information
** Author: Hossein Toutounchi
** Date: oct 20th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class LeapYearInformation
{
	public static void main(String[] args)
	{
        /**
         * The main purpose of this method is to capture the entry and repeat the process until the user asked no.
         * this method will evaluate if the entered year is leap or not and what is the next leap year.
         */

	    int year, dayOfWeek, dayOfWeekNext;
	    String action;
	    Scanner input = new Scanner(System.in);

		do
		{
            //This loop will repeat the program as long as the user enters yes.

		    System.out.println("Please enter a year greater than 1582:");
		    year = input.nextInt();
		    input.nextLine();
		
		    if (verifyYear(year))
		    {
                //verifies the user input and continues if the verify is correct.

		        if(leapYear(year))
		        {
                    //If the year is the leap year the program continues, It will display the day of feb 29th of the year and next one that matches.

		            dayOfWeek = zeller(29,2,year);
		            System.out.println("Feb 29, " + year + " is on " + weekDay(dayOfWeek));
		            year = nextYearCalc(29,2,dayOfWeek, year);
		            dayOfWeekNext = zeller(29,2,year);
		            System.out.println("The next leap year where Feb 29 is on " + weekDay(dayOfWeekNext) + " year " + year);
		    }   
		        else
		            System.out.println("year " + year + " is not a leap year");
		    }

		    // If the year is not leap or the entry is wrong the program will promt to run again.

		    System.out.println("Do you want to repeat the program:");
		    action = input.nextLine();
		    
		}while (action.equalsIgnoreCase("yes"));
	}
	
	public static boolean verifyYear(int year)
	{
        /**
         * This program verify the entry which is larger than 1582
         */

	    boolean verification = true;
	    if (year<1582)
	    {
	        System.out.println("Year you have entered in smaller than 1582,");
	        System.out.println("there were no leap years before the introduction of the Gregorian Calendar on October 15, 1582.");
	        verification = false;
	    }
	    return verification;
	}

	public static int zeller(int day, int month, int year)
	{
        /**
         * This method calculates the Zeller based on the year entry, month and day.
         * In our case feb 29 will make the day 29 and the month 2.
         */

	    int startYear, startDay, startMonth, leapFactor, zeller;
	    
	    if (month<3)
	    {
	        startMonth = 0;
	        startYear = year - 1;
	    }
	    
	    else
	    {
	        startMonth = (int) ((0.4 * month) + 2.3);
	        startYear = year;
	    }
	    
        leapFactor = (startYear/4) - (startYear/100) + (startYear/400);
        zeller = ((365 * year + 31 * (month - 1) + day + leapFactor - startMonth) - 1)%7;
        return zeller;
	}
	
	public static String weekDay (int num)
	{
        /**
         * This method will match the zellers value with the coresponding day
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
                weekDay = "Saturday";
                break;
                
            case 6:
                weekDay = "Sunday";
                break;
        }
        return weekDay;
	}

    public static boolean leapYear(int year)
    {
        /**
         * This method verifies the leap year and find out if the year is leap or not.
         */

        boolean leapYear = false;
        if(year%4==0)
        {
            leapYear =true;
            if (year%100==0)
                leapYear = false;
            if (year%400==0)
                leapYear = true;
        }
        return leapYear;
    }
    
    public static int nextYearCalc(int day, int month,int dayOfWeek, int year)
    {
        /**
         * This method Calclulates the next leap year based on the previous year 
         * It will capture and return the next leap year which has the same day on feb 29th.
         */

        boolean leapYear = false;
        
        for(int i=year+4; ;i+=4)
        {
            //This for loop finds out the next leap year.

            if (verifyYear(i))
            {

                //This loop compares the days and returns the next year which has same day on feb29th.
                
                int zellerNum = zeller(29,2,i);
                    
                if (zellerNum == dayOfWeek)
                    {
                        return i;
                    }
            }
        }
    }
}
