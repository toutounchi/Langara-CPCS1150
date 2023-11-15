import java.util.Scanner;
public class AreaVolume
{
    public static void main (String[] arg)
    {
    double radius;
    int cylinder;
    double area;
    double volume;
            
    Scanner input = new Scanner(System.in);
            
    System.out.println("Enter the radius of the cylinder:");
    radius = input.nextDouble();
            
    System.out.println("Enter the length of the cylinder:");
    cylinder = input.nextInt();
            
    area = radius * radius * Math.PI ;
    volume = area * cylinder;
    System.out.println("Based on the numbers you have entered\nyour area is:" + area + "\nyour volume is:" + volume);
    }
}