import java.util.Scanner;

/**
** Program Name: Stock Calculator
** Author: Hossein Toutounchi
** Date: sep 15th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class StockCalc
{
    public static void main (String[] arg)
    {

    /**
    ** This program calculates the value of shares, the total commisions and the net proceeds
    * based on the information (stock price, number of shares and the commission rate) user gives.
    */

        double stockPrice, commisions , totalCommisions , netProceeds, valueOfShares ;
        int numberOfShares;
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the stock price:");
        stockPrice = input.nextDouble();
        
        System.out.println("Please enter the number of shares:");
        numberOfShares = input.nextInt();
        
        System.out.println("Please enter the commission rate:");
        commisions = input.nextDouble();
        
        valueOfShares = stockPrice * numberOfShares ;
        totalCommisions = valueOfShares * commisions ;
        netProceeds = valueOfShares - totalCommisions ;
        
        System.out.println("Based on the infromation you enetered");
        System.out.println("Your value of shares is:" + valueOfShares);
        System.out.println("Your total commisions are:" + totalCommisions);
        System.out.println("Your net proceeds are:" + netProceeds);
    }
}