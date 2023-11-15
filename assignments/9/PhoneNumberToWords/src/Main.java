import java.util.*;
import java.io.*;

/**
 ** Program Name: Phone Number to words
 ** Author: Hossein Toutounchi
 ** Date: Nov 10th, 2023
 ** Course: CPSC 1150
 ** Compiler: JDK 20.0.2
 */

public class Main
{
    /**
     * The program will read a phone number from the user and will check if it can be translated into one
     * or more words of words.txt file. The output of the program will contain the telephone numbers and
     * their word representatives. The output will be displayed on the console as well as in a file called
     * phonesText.txt. Program will continue until the user enters anything than "Yes".
     */

    public static void main(String[] args) throws IOException
    {
        // First we promt the user to enter the phone number.
        String number, entry;
        Scanner input = new Scanner(System.in);
        PrintWriter outfile = new PrintWriter(new File("phonesText.txt"));
        System.out.println("**Welcome to PhoneNumberToWords APP**");

        // Repeat the program until we get anything than "yes" from user
        do {
            System.out.println("PLease Enter a 7 digit phone number [nnn-nnnn]");
            number = input.nextLine();

            //Check the user's phone number for correctness and run through methods to get the coresponding words.
            if (verifyInput(number)) {
                System.out.println("Entry:" + number);
                outfile.println("For the phone number: " + number);
                number = number.substring(0, 3) + number.substring(4, 8);
                wordFinder(number, outfile);
            }

            System.out.println("Would you like to reapet the program?");
            entry = input.nextLine();
        }while(entry.equalsIgnoreCase("yes"));

        System.out.println("Thanks for using our program file \"phoneText.txt\" has been created for your entires!");
        outfile.close();
    }

    public static boolean verifyInput(String number)
    {

         //This method checks for the correctness of the phone number entered.
        boolean verify = true;

        if (number.length()>8)
        {

            //phone number can not contain more than 7 digits.
            System.out.println("Your number must have only 7 digits");
            verify = false;
        }

        if (number.indexOf('-')!= 3)
        {
            //phone number must include the (-).
            System.out.println("Your phone number must be in this format: [nnn-nnnn]");
            verify = false;
        }

        for (int i = number.length()-1; i>=0; i--)
        {
            //None of the digits can be 0 or 1.
            if (number.charAt(i) == '0' || number.charAt(i) == '1')
            {
                System.out.println("Your number can not contain 0 or 1");
                verify = false;
            }
        }
        return verify;
    }

    public static void wordFinder(String number, PrintWriter outfile) throws IOException
    {

         //This method find the words that match the phone number in words.txt if any.
        String temp = "", numStr;
        boolean verify = false;
        Scanner infile = new Scanner(new File("words.txt"));

        while (infile.hasNextLine())
        {
            //Checks every single line of the words.txt to see if there is any match.
             temp = infile.nextLine();
             numStr = numFinder(temp);
            if (numStr.equals(number))
            {
                System.out.println(temp);
                outfile.println(temp);
                verify = true;
            }
        }

        if (!verify)
        {
            //If there was no match then it will print no match on console and the file.
            System.out.println("No match");
            outfile.println("No match");
        }

    }

    public static String numFinder(String temp)
    {

         //This method finds what number each word of the file represent
        String numStr = "";
        for (int i = 0; i<temp.length() ; i++)
        {
            //Checks the number for every single line.
            numStr += digitFinder(temp.charAt(i));
        }

        //Puts all the numbers together and return the string.
        return numStr;
    }

    public static int digitFinder (char character)
    {

        //This method finds the coresponding number for each letter of the words.txt file.
        switch (character)
        {
            case 'A':
            case 'B':
            case 'C':
                return 2;

            case 'D':
            case 'E':
            case 'F':
                return 3;

            case 'G':
            case 'H':
            case 'I':
                return 4;

            case 'J':
            case 'K':
            case 'L':
                return 5;

            case 'M':
            case 'N':
            case 'O':
                return 6;

            case 'P':
            case 'Q':
            case 'R':
            case 'S':
                return 7;

            case 'T':
            case 'U':
            case 'V':
                return 8;

            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                return 9;
        }

        return 0;
    }
}