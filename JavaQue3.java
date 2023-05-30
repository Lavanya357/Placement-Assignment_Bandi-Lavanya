import java.util.Scanner;
class NegativeIntegerException extends Exception
{
	
}
public class JavaQue3 {

	public static void main(String[] args) {
		try
		{
		int value;
		System.out.println("Enter a number");
		Scanner sc=new Scanner(System.in);
		value=sc.nextInt();
		if(value>=0)
		{
			System.out.println("Positive Integer");
		}
		else
		{
			NegativeIntegerException nie=new NegativeIntegerException();
			System.out.println(nie);
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
	
	

