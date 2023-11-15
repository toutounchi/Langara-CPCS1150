import java.util.Scanner;

/**
** Program Name: word calculator
** Author: Hossein Toutounchi
** Date: oct 6th, 2023
** Course: CPSC 1150
** Compiler: JDK 20.0.2
*/

public class StringManipulation
{
	/**
	 * This program will calculate the number of words, number of vowels,
	 * the longest word and the word with the most vowel words in the sentence for the user.
	 */

	public static void main(String[] args) {
	    
	    String entry ;
	    int action = 0;
	    Scanner input = new Scanner(System.in);
	    
		//First we ask the user to enter the sentence.

	    System.out.println("Welcome to word calculator");
	    System.out.println("Please enter a sentence:");
	    entry = input.nextLine();
	    
	    do
	    {
			// then we display our menu option for the user to guide through our methods.

		    System.out.println("\n1. To display the number of words in the sentence.");
		    System.out.println("2. To display the number of vowel characters in the sentence.");
		    System.out.println("3. To display the word with the most number of characters.");
		    System.out.println("4. To display the word with the most vowels.");
		    System.out.println("5. To enter a new statement.");
		    System.out.println("6. To terminate the program.");
		    action = input.nextInt();
		    input.nextLine();
		    
			//Switch is used in this case to guide our program through different methods.

		    switch(action) 
		    {
		        case 1:
		        wordsInSent(entry);
		        System.out.println("\"" + entry +"\"");
		        break;
		        
		        case 2:
		        numVowelChar(entry);
		        System.out.println("\"" + entry +"\"");
		        break;
		        
		        case 3:
		        wordMostNum(entry);
		        break;
		        
		        case 4:
		        wordMostVow(entry);
		        break;
		        
		        case 5:
		        System.out.println("\nPlease enter a new sentence:");
		        entry = input.nextLine();
		        break;
		        
		        case 6:
		        System.out.println("\nThanks for using word calculator. \nEnd of the program.");
		    }
	    } while (action<6);	    
	}
	
    public static void wordsInSent(String sentence)
	{
		// This method will calculate the number of words in the sentence.

	    sentence = sentence.trim();
	    int a, words = 0 ;
	    
        do
        {
	        sentence = sentence.trim();
	        a = sentence.indexOf(" ");
	        sentence = sentence.substring(a+1);
	        words++;
	        
        } while (a!=-1);     
        
        System.out.println("\nThere are " + words + " words in: ");
	}
	
	public static void numVowelChar(String sentence)
	{
		//This method will calculate the number of vowel characters 'a', 'e', 'o', 'i' and 'u'.

	    sentence = sentence.toLowerCase();
	    int length = sentence.length();
	    int numA = 0, numE = 0, numO = 0, numI = 0, numU = 0;
	    
		//this loops checks for every vowel in each character of the sentence.

	    for (int i=0; length> i; i++)
	    {
        char vow = sentence.charAt(i);	   
	    if (vow == 'a') 
	    numA++;
	    if (vow == 'e')
	    numE++;
	    if (vow == 'o')
	    numO++;
	    if (vow == 'i')
	    numI++;
	    if (vow == 'u')
	    numU++;
	    }
	    
	    System.out.println("\nThere are:\n" + numA + "a's \n" + numE + "e's \n" + numI + "i's \n" + numO + "o's \n" + numU + "o's" + "\nin");
	}
	
    public static void wordMostNum(String sentence)
	{
		
		//This method will find the word which has the highest number of characters.

	    int a, lengthOfWord, lengthOfWorldFinal;
	    String longWord = "", word = "";
	    
	    do
	    {
			//checks how many character each word is and replace it with the original which is an empty string.

	        sentence = sentence.trim();
	        a = sentence.indexOf(" ");
	        
	        if (a==-1)
	            word = sentence;
	        else
	            word = sentence.substring(0,a);
            
            if (word.length() > longWord.length())
	            longWord = word;
	            
	        sentence = sentence.substring(a+1);
	    } while (a!=-1);     
	    
	   System.out.println("\nThe longest word is: " + "\"" + longWord + "\"");
	}
	
	public static void wordMostVow (String sentence)
    {
     
	 //This method find the word which has the highest number of vowel characters.

        int a, lengthOfVow= 0, lengthOfVowFinal = 0;
	    String word = "", wordFinal = "";
	    do
	    {
	        sentence = sentence.trim();
	        a = sentence.indexOf(" ");
	        int numA = 0, numE = 0, numO = 0, numI = 0, numU = 0;
	        
			//checks each word, calculate the vowels for each word and compare them with the last one.

	        if (a==-1)
	            word = sentence;
	        else
	            word = sentence.substring(0,a);
	            
            for (int i=0; i< word.length() ; i++)
	            {
                char vow = sentence.charAt(i);	   
	            if (vow == 'a') 
	            numA++;
	            if (vow == 'e')
	            numE++;
	            if (vow == 'o')
	            numO++;
	            if (vow == 'i')
	            numI++;
	            if (vow == 'u')
	            numU++;
	            }
            lengthOfVow = numA + numE + numO + numI + numU;

			//If the number of vowels is higher than the previous one the word will be replaced.

	        if (lengthOfVow > lengthOfVowFinal)
	            wordFinal =  word;
	            lengthOfVowFinal = lengthOfVow;
	            
	        sentence = sentence.substring(a+1);
	           
	    } while (a!=-1);     
	        
	    
	   System.out.println("\nThe word with the most vowels is: " + "\"" + wordFinal + "\" " );
	   
    }
}

