import java.util.Scanner;

/**
** Program Name: WindChill Calculator
** Author: Hossein Toutounchi
** Date: sep 22nd, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class WindChill
{
    /**
    ** This program will help the user to find the wind chill index which is calculated 
    ** based on the windchill formula, First the program checks for valid entries; if all the entries are 
    ** within the range, then it will calculate The windchill based on the formula
    */    
            
    public static void main(String[]arg)
    {

        double windSpeed, temperature, windChill;
        Scanner Input = new Scanner(System.in);

        //First we Ask for both of the temperature and windpspeed and we store them

        System.out.println("***Welcome to WindChill index app");
        System.out.println("**temperature range must be between -50ºC and 5ºC.**");
        System.out.println("Please enter your temperature");
        temperature = Input.nextDouble();
                
        System.out.println("**Wind speed must be between 0 and 100 km/h.**");
        System.out.println("Please enter the wind speed");
        windSpeed = Input.nextDouble();

        //Secondly We check for the wrong entries and return if either is wrong.
              
        if (-50 >= temperature || temperature >= 5)
        {
            System.out.println("Error! The temperature you entered is not between -50ºC and 5ºC");
            return;
        }

        if (0 >= windSpeed || windSpeed >= 100)
        {     
            System.out.println("Error! The windspeed you entered is not between 0 and 100 km/h");
            return;
        }

        //Finally if the entries are valid we calculate the WindChill based on the formula and display it.
        
        windChill = 13.112 + 0.6215 * temperature - 11.37 * Math.pow(windSpeed,0.16) + 0.3965 * temperature * Math.pow(windSpeed,0.16);
        System.out.println("the windchill index based on your entries are: "+ (int)(windChill));
    }
}