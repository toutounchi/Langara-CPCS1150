public class TwoDigitsTest
{
	public static void main(String[] args)
	{
		double base, rate, howMuch;
      
		base = 50.6854;
		rate = .90877;
      
		howMuch = base * rate;
      
		System.out.println("howMuch is: " + howMuch);
      
		//Using printf to display two digits after the decimal point
		System.out.printf("\nhowMuch using printf is: %.2f ", howMuch);
      
		//Using Math.round method to modify the howMuch variable to include 2 didgits after the decimal point
		System.out.println("\nMath.round(howMuch) is: " + Math.round(howMuch));
		howMuch = Math.round(howMuch * 100);
		System.out.println("\nNow howMuch is: " + howMuch / 100);
      
	}
}