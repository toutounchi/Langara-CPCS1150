import java.io.*;
import java.util.*;

/**
 ** Program Name: CS Course Information
 ** Author: Hossein Toutounchi
 ** Date: Nov 6th, 2023
 ** Course: CPSC 1150
 ** Compiler: JDK 20.0.2
 */

public class CSCourseInformation
{
    /**
     * This program read the file classList.txt and help the user to find the scores
     * that match each student. Finds the highest grade in class and the average and also
     * generates a text file which is a copy of the records for user.
     */

    public static void main(String[] args) throws IOException
    {
        int selection;
        Scanner input = new Scanner(System.in);

        do
        {
            // First we prompt the user to enter a digit from 1-5 for each of the methods and continue repeating until 5 is entered.

            System.out.println("Please enter:");
            System.out.println("1. To display a specific student’s record.");
            System.out.println("2. To calculate the final exam average.");
            System.out.println("3. To find a student with the highest score on the final exam.");
            System.out.println("4. To copy the students’ record to another file.");
            System.out.println("5. To terminate the program.");
            selection = input.nextInt();
            selectionSwitch(selection);

        }while(selection!=5);

        System.out.println("Thanks for using the application!");


    }
    public static void selectionSwitch(int entry) throws IOException
    {
        //This switch helps the user to go through each method based on the number the user enters.

        switch(entry)
        {
            case 1 :
                studentRecord();
                break;

            case 2 :
                averageCalc();
                break;

            case 3 :
                highestScore();
                break;

            case 4 :
                studentRec();
                break;

        }
    }

    public static void studentRecord() throws IOException
    {
        //This method matches the name user enters with the class list.

        String studentName;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the student’s name:");
        studentName = input.nextLine();

        //We define the scanner our text file so we can read each line and search for name.

        Scanner infile = new Scanner (new File("classList.txt"));
        boolean result = false;
        while (infile.hasNextLine())
        {
            //While infile has next line we repeat this process to cover all the lines, If we have a match we return the values
            //for name, ID and name. If not it displays no match.

            String line = infile.nextLine();
            if (line.contains(studentName))
            {
                int i = line.indexOf(":");
                String subLine = line.substring(i+1);
                System.out.println("Name: " + subLine.substring(0,subLine.indexOf(":")));
                System.out.println("ID: " +line.substring(0,i));
                System.out.println("Final: " + subLine.substring(subLine.indexOf(":")));
                result = true;
            }
        }
        if (!result)
            System.out.println("Record indicate that there is no Match!");

        infile.close();
    }

    public static void averageCalc() throws IOException
    {
        //This method calculate the average of the class.

        Scanner infile = new Scanner (new File("ClassList.txt"));

        int count = 0;
        double average, score = 0;
        infile.nextLine();
        infile.nextLine();
        while (infile.hasNextLine())
        {

            //Reads every line and stores the values as double number. notice we need to skip 2 lines since we have the format and
            // an empty line in the beginning of our text file. finally we devide the total of grades with the total number of grades
            //and display it.

            String line = infile.nextLine();
            String subLine = line.substring((line.indexOf(":"))+1);
            score += Integer.parseInt(subLine.substring(subLine.indexOf(":")+1));
            count++;
        }
        average = score/count;
        System.out.println("The average score for the students were: " + average);

        infile.close();
    }

    public static void highestScore() throws IOException
    {
        //This method checks every score and store the largest as the highest grade.

        Scanner infile = new Scanner (new File("ClassList.txt"));
        infile.nextLine();
        infile.nextLine();
        int score= 0, temp;
        while (infile.hasNextLine())
        {
            //checks for every possibility as long as a line is in the text and displays the highest grade on the console.

            String line = infile.nextLine();
            String subLine = line.substring((line.indexOf(":"))+1);
            temp = Integer.parseInt(subLine.substring(subLine.indexOf(":")+1));
            if (temp> score)
                score = temp;
        }
        infile.close();
        System.out.println("The highest score in the class is: " + score);
    }

    public static void studentRec() throws IOException
    {
        //This method creates a new file and copy and paste everything in the new file.

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the file name: ");
        String name = input.nextLine();

        //We create the new file based on the name the user enters and store it in same folder.

        Scanner infile = new Scanner (new File("ClassList.txt"));
        PrintWriter outFile = new PrintWriter((name + ".txt"));

        while (infile.hasNextLine())
        {
            //Makes sure all the lines gets copied as long as they exist.

            String print = infile.nextLine();
            outFile.println(print);
        }
        infile.close();
        outFile.close();

        System.out.println("Your record are available in file \"" + name + ".txt\" In same folder!");
    }
}