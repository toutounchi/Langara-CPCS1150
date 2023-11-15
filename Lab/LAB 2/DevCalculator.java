import java.util.Scanner;

/**
** Program Name: Devisavle Calculator
** Author: Hossein Toutounchi
** Date: sep 22nd, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class DevCalculator
{
    public static void main(String[]arg)
    {
        
        /**
        ** This program will help the user to find out if the fist number is devisable with the second
        ** if the remainder of the first number devided by the second equals to zero it will show the 
        * that they are devisable if not they are not devisable.
        */ 
        
        int FirstNum, SecondNum;
        Scanner Input = new Scanner(System.in);
            
        System.out.println("***Welcome to the Dev Calculator***");
        System.out.println("Please enter your first number");
        System.out.println("Your numbers can't be negative and the first entry must be bigger than the second.");
        FirstNum = Input.nextInt();
            
        System.out.println("Please enter your second number");
        SecondNum = Input.nextInt();
            
        if(FirstNum <= SecondNum || FirstNum <= 0 || SecondNum <= 0)
        {
            
            if (FirstNum<= SecondNum)
            {
                System.out.println("Error!\nThe second number you have entered is bigger than the firts one");
            }
            
            else 
            {
                System.out.println("Error! \nThe numbers you entered can not be negative.");
            }
            return;
        }   
                
        if (FirstNum % SecondNum == 0)
        {
            System.out.println(FirstNum + " is devisable by " + SecondNum);
        }
        else
        {
            System.out.println(FirstNum + " is not devisable by " + SecondNum);
        }    
    }
}    