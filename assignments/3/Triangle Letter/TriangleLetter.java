import java.util.Scanner;

/**
** Program Name: Triangle Letter
** Author: Hossein Toutounchi
** Date: sep 29th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class TriangleLetter
{
    public static void main (String[] args)
    {

    /**
    * This program will take generate a triangle of letters
    * based on the number of letter the user enters
    */    

        int num;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter a number between 1 and 26");
        num = input.nextInt();
        
        //First we check if the users entry is within the range we asked for

        if (num<1 || num>26)
        {
            System.out.println("The number you have entered is not in the range");
            return;
        }
        
        //Second we need one for loop for the rows and two for loops one for printing the numbers
        //and another one to create spaces before numbers to make it look like a triangle.
        
       for (int i=1 ; i<=num ; i++)
        {
            System.out.println();
            for (int s =num ; s>i ; s--)
            {
                System.out.print(" ");
            }
            for (char j ='A'; j < i + 'A' ; j++)
            {
                System.out.print(j);
            }
        }
    }
}