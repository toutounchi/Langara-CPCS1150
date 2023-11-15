/**
** Program Name: Pentagonal Calculator
** Author: Hossein Toutounchi
** Date: oct 6th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class PentCalc
{
	public static void main(String[] args) 
	{

	/**
    * This program will generate the pentagonal number for n=1 up to n=10
    */  

	    int num =1;
	    
		//we need a loop to continue the program 10 times and print the 10 pentagonal numbers

		for (num=1 ; num <= 10; num++)
		{
		    int pent = getPentagonalNumber(num);
		    System.out.println(pent);
		}    
	}
	
	public static int getPentagonalNumber(int num)
    {   

		// This is our method to calculate the petagonal numbers for us
		
        int i;
        i = num*(3*num-1)/2 ;
        return i;
    }
}
