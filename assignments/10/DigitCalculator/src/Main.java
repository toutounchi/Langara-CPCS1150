import java.util.*;

/**
 ** Program Name: Digit Calculator
 ** Author: Hossein Toutounchi
 ** Date: Nov 17th, 2023
 ** Course: CPSC 1150
 ** Compiler: JDK 20.0.2
 */

public class Main {
    /**
     * This program prompt the user for two entries and evaluate if all the characters are digit
     * and its less than 40 digits. Then if that is true the program will calculate the sum of two and display it.
     * @param args
     */
    public static void main(String[] args)
    {
        String num1, num2;
        Scanner input = new Scanner(System.in);

        //Get the user to enter a string and check it with verify method.
        System.out.println("Enter the first positive integer number with up to 40 digits:");
        num1 = input.nextLine();
        System.out.println("Enter the second positive integer number with up to 40 digits:");
        num2 = input.nextLine();

        if (verify(num1) & verify(num2))
        {
            //Here we check for the user's entries and pass the longest to the method first.
            if(num1.length()>num2.length())
                calculate(num1, num2);
            else
                calculate(num2,num1);
        }
    }
    public static boolean verify(String entry)
    {
        //this method will check every single entry from the string that user entered and check if it is not a digit.
        if(entry.length()<=0)
        {
            System.out.println("Your input:" + entry+ "is incorrect.\n" + "Expecting up to 40 digit number");
            return false;
        }

        for (int i = 0; i<entry.length(); i++)
        {
            //For every index of string we check for the digit.
            char temp = entry.charAt(i);
            if (!Character.isDigit(temp))
            {
                //We return as soon as we find there is not a digit character.
                System.out.println("Your input:" + entry + "is incorrect.\n" + "Expecting all digit characters.");
                return false;
            }
        }
        return true;

    }

    public static String commaGenerator (String sum)
    {
        int count = 0;
        String sumFinal = "";
        for(int i= sum.length()-1; i>=0;i--)
        {
            if(count!=3)
            {
                sumFinal = sum.charAt(i) + sumFinal;
                count++;
            }
            else
            {
                sumFinal =  sum.charAt(i) + "," + sumFinal;
                count = 1;
            }
        }
        return sumFinal;
    }

    public static void calculate(String num1, String num2)
    {
        //Our main method to calculate the two strings entered as a whole number

        int temp1, temp2 , carryOver = 0,  h= num2.length()-1;
        String sum = "";

        for (int i = num1.length()-1; i>=0; i--)
        {
            //We set Caclc to 0 for everytime we want to calculate the new digit.
            int calc = 0;
            temp1 = num1.charAt(i) - '0';

            //If our smallest string has a number we convert that if not we would just set it to Zerp.
            if (h<0)
                temp2 = 0;
            else
            {
                temp2 = num2.charAt(h) - '0';
                h--;
            }

            //We calculate the number based on our digits from the string and carryover.
            calc = temp1 + temp2 + carryOver;

            //If the calculated number is larger than 10 we add the extra to carryover and calculate it in the next loop.
            if (calc>=10)
            {
                carryOver = calc / 10;
                calc = calc % 10;
            }
            else
            {
                carryOver = 0;
            }

            sum = calc + sum;
        }
        //If the carryover for the last digit is bigger than 0 we need to include that.
        if (carryOver>0)
            sum = carryOver + sum;

        System.out.println("The output should be:");
        for(int i = 0; i<= num1.length() - num2.length(); i++)
            System.out.print(" ");
        System.out.println(commaGenerator(num2));
        System.out.println(commaGenerator(num1)+ "+");
        for (int i = 0; i<=num1.length();i++)
            System.out.print("-");
        System.out.println();
        System.out.println(commaGenerator(sum));
    }
}