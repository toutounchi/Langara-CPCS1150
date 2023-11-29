import java.util.*;

/**
 ** Program Name: Digit Verify
 ** Author: Hossein Toutounchi
 ** Date: Nov 17th, 2023
 ** Course: CPSC 1150
 ** Compiler: JDK 20.0.2
 */

public class Main {
    /**
     * This program prompt the user for an entry and evaluate if all the characters are digit
     * and its less than 40 digits.
     * @param args
     */
    public static void main(String[] args)
    {
        String entry;
        Scanner input = new Scanner(System.in);

        //Get the user to enter a string and check it with verify method.
        System.out.println("Enter a positive integer number up to 40 digits:");
        entry = input.nextLine();
        if (entry.length()<=40)
            verify(entry);
        else
            System.out.println("Your input is incorrect.\n" + "Expecting up to 40 digit number");
    }
    public static void verify(String entry)
    {
        //this method will check every single entry from the string that user entered and check if it is not a digit.
        boolean check = false;
        for (int i = 0; i<entry.length(); i++)
        {
            //For every index of string we check for the digit.
            char temp = entry.charAt(i);
            if (!Character.isDigit(temp))
            {
                //We return as soon as we find there is not a digit character.
                System.out.println("Your input is incorrect.\n" + "Expecting all digit characters.");
                return;
            }
        }
        //The input is correct if all the characters are digit.
        System.out.println("Your input is correct.");
    }
}