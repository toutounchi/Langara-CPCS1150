import java.io.*;
import java.util.*;

/**
 ** Program Name: Student Information
 ** Author: Hossein Toutounchi
 ** Date: Nov 3rd, 2023
 ** Course: CPSC 1150
 ** Compiler: JDK 20.0.2
 */

public class StudentInformation
{
    /**
     * The purpose of this method is to read the file "classList.txt" and find
     * the record of the student prompted. Then it will display the results name, student ID and grade.
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws IOException
    {
        //First we prompt the user to get the name of the student and then we envoke the studentRecod method.

        String studentName;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the student’s name:");
        studentName = input.nextLine();

        studentRecord(studentName);
    }

    public static void studentRecord(String name) throws IOException
    {
        //First we define the Scanner and connect it to the file and then start reading the file while the File has lines.

        boolean result = true;
        Scanner infile = new Scanner (new File("classList.txt"));

        while (infile.hasNextLine()) {
            String line = infile.nextLine();
            if (line.contains(name)) {

                //If the Scanner contains the word the user enter this loop will match and display it.

                int i = line.indexOf(":");
                String subLine = line.substring(i + 1);
                System.out.println("Name: " + subLine.substring(0, subLine.indexOf(":")));
                System.out.println("ID: " + line.substring(0, i));
                System.out.println("Final: " + subLine.substring(i));
                result = false;
            }
        }
        if (result)
            System.out.println("sorry there is no match");
    }
}


