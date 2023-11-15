import java.util.Scanner;


public class Main
{
	public static void main(String[] args) 
	{
	    String studentName;
	    Scanner input = new Scanner(System.in);
	    System.out.println("Please enter the student’s name:");
	    studentName = input.nextLine();
	    
	    studentRecord(studentname);
	}
	
	public static void studentRecord(String name)
	{
	    int num;
	    Scanner infile = new Scanner (new File(“classList.txt”));
	    while (infile.hasnextLine())
	        num++;
	    System.out.println(num);
	}
}

