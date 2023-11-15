import java.util.Scanner;

/**
** Program Name: TriangleCalculator
** Author: Hossein Toutounchi
** Date: oct 6th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class TriangleCalc
{
	/**
	 * This program will help the user to find the perimeter of a triangle, A triangle is defined by
	 * the x- and y-coordinates of its three corner points.
	 */

	public static void main(String[] args)
	{
		
		int x1, x2, x3, y1, y2, y3;
		String respond;
		Scanner input = new Scanner(System.in);

		do

		//Read x/y coordinates for the tirangle put it in verification and calculation method. Repeat it until user says no to repeat.
	    	{
	        System.out.println("Welcome to triangle premeter calculator");
	        System.out.println("This program calculates the perimeter of a Triangle.");
	        System.out.println("*Your values must be between 0 and 40*");
	        System.out.println("*Also your points can't form a line*");
	    
	        System.out.println("Please enter the x-coordinate of point 1:");
	        x1 = input.nextInt();
	    
	        System.out.println("Please enter the y-coordinate of point 1:");
	        y1 = input.nextInt();
	    
	   	    System.out.println("Please enter the x-coordinate of point 2:");
	        x2 = input.nextInt();
	    
	        System.out.println("Please enter the y-coordinate of point 2:");
	        y2 = input.nextInt();
	    
	        System.out.println("Please enter the y-coordinate of point 3:");
	        x3 = input.nextInt();
	    
	        System.out.println("Please enter the y-coordinate of point 3:");
	        y3 = input.nextInt();
	    
	        if(verify_input(x1,y1,x2,y2,x3,y3))
	        {
	            double finalperimeter = perimeterCalc(x1,y1,x2,y2,x3,y3);
	            System.out.println("The perimeter of a Triangle with point1 (" + x1 + "," + y1 + "), point2 (" + x2 + "," + y2 + ") and point3 (" + x3 + "," + y3 + ") is " + finalperimeter);
	        }
	        
	        System.out.println("Would you like to repeat the program?");
	        respond = input.next().toLowerCase() ;
	        
		}while (!respond.equals("no"));
	    
		System.out.println("End of the program.");
	    
	}
	
	public static double perimeterCalc(int point1_x, int point1_y, int point2_x, int point2_y, int point3_x, int point3_y)
	{
		/**
		 * This method will help us calculate the perimeter of the triangle based on math formula
		 */

	    double side1 = Math.sqrt((Math.pow(Math.abs(point2_x - point1_x), 2))+ (Math.pow(Math.abs(point2_y - point1_y), 2)));
	    double side2 = Math.sqrt((Math.pow(Math.abs(point3_x - point2_x), 2))+ (Math.pow(Math.abs(point3_y - point2_y), 2)));
	    double side3 = Math.sqrt((Math.pow(Math.abs(point1_x - point3_x), 2))+ (Math.pow(Math.abs(point1_y - point3_y), 2)));
	    double perimeter = side1 + side2 + side3;
	    return perimeter;
	}
	
	
	public static boolean verify_input(int point1_x, int point1_y, int point2_x, int point2_y, int point3_x, int point3_y)
	{
	
		/**
		 * This method helps us verify the range of entries which is between 0 and 40. Also checks that the points 
		 * don't form a line with math formulas.
		 */
	    
	    if (point1_x < 0 || point2_x < 0 || point3_x < 0)
	    {
	       System.out.println("Your x values can't be smaller than zero");
	       return false; 
	    }
	    
	    if (point1_y < 0 || point2_y < 0 || point3_y < 0)
	    {
	       System.out.println("Your y values can't be smaller than zero");
	       return false;
	    }
	    
	    if (point1_x > 40 || point2_x > 40 || point3_x > 40)
	    {
	        System.out.println("Your x values can't be greater than 40");
	        return false;
	    }     
	    
	    if (point1_y > 40 || point2_y > 40 || point3_y > 40)
	    {
	        System.out.println("Your y values can't be greater than 40");
	        return false;
	    } 
	    
	    if (point1_x == point2_x && point2_x == point3_x)
	    {
	        System.out.println("your points Can not form a line");
	        return false;
	    }
	    
	    if (point1_y == point2_y && point2_y == point3_y)
	    {
	        System.out.println("your points Can not form a line");
	        return false;
	    }
	    
		// Math formula for checking if the  points form a line. Cross multiply since we don't want zero in denominator

	    double slope1 = (point2_y - point1_y) * (point3_x - point2_x);
	    double slope2 = (point3_y - point2_y) * (point2_x - point1_x);
	    double slope3 = (point3_y - point1_y) * (point3_x - point1_x);
	    
	    if(((slope1 - slope2) < Math.pow(10, -10) && (slope2 - slope3) < Math.pow(10, -10)))
	    {
	        System.out.println("your points Can not form a line"); 
	        return false;
	    }   
	   return true;
	}
}