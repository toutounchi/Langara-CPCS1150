import java.util.Scanner;

/**
** Program Name: Words in sentence Calculator
** Author: Hossein Toutounchi
** Date: oct 13th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class NumberOfWords
{
	public static void main(String[] args) 
	{
		/**
		 * This program will find out how many words are in an specefic sentence.
		 */

	    int num;
	    String object;
	    Scanner input = new Scanner(System.in);
	    
		//We Capture the sentence that the person enters and find the word count with our method.

		System.out.println("Please enter a Sentence");
		object = input.nextLine();
		num = words(object);
		
		System.out.println("There are " + num + " words in:");
		System.out.println(object);
		
	}
	public static int words(String object)
	{
		/**
		 * This method helps us trim the sentence and find out the place of each word and calculate the total word counts.
		 */
		
	    object = object.trim();
	    int a, words;
	    words = 0;
	    
        do
        {
	        object = object.trim();
	        a = object.indexOf(" ");
	        object = object.substring(a+1);
	        words++;
	        
        } while (a!=-1);     
    
	    return words; 
	}
}