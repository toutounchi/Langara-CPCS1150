public class ArrayDemo
{
    /**
    ** Program Name: Array Demo
    ** Author: Hossein Toutounchi
    ** Date: oct 27th, 2023
    ** Course: CPSC 1150
    ** Compiler: JDK 20.0.2
    */

    public static void main(String[] args) 
    {
        /**
         * This part of the code was given to us by the question, its basically generating random numbers
         * Then displaying them and finidng their average and then reversing them.
         */

        int[] numbers = new int[20]; initializeArray(numbers);
        System.out.println("The random numbers are:"); displayArray(numbers);
        System.out.println("The smalles number in the list : " + getSmallest(numbers));
        System.out.println("The average of the array elements is; " + getAverage(numbers));
        reverseArray(numbers);
        System.out.println("The random numbers in reverse are:"); displayArray(numbers);
    }
    
    public static void initializeArray(int []numbers)
    {
        //This method initializes the array by assigning random numbers to them.

        for (int i=0; i<20; i++)
        {
            numbers[i] = (int)(Math.random() * 101);     
        }
    }
    
    public static void displayArray(int []numbers)
    {
        //This method dsiplays each part of the array with a for loop.

        for(int i=0; i<numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
    }
    
    public static int getSmallest(int [] numbers)
    {
        //This method finds the smallest integer in the array by comparing them.

        int small = numbers [0];
        for (int i = 1; i<numbers.length; i++)
        {
            if (numbers[i]<small)
            small = numbers[i];
        }
        return small;
    }
    
    public static double getAverage(int []numbers)
    {
        //This method finds the average based on the numbers of the array.

        int sum = numbers[0], average;
        for (int i = 1; i<numbers.length; i++)
        {
            sum += numbers[i];
        }
        average = sum/numbers.length;
        return average;
    }
    
    public static void reverseArray(int [] numbers)
    {
        // This method reverses the array that store it in the original array.
        
        for(int i=0;i<(numbers.length/2);i++)
        {
            int store = numbers[i];
            numbers[i] = numbers[(numbers.length-1)-i];
            numbers[(numbers.length-1)-i] = store;
           
        }
    }
}