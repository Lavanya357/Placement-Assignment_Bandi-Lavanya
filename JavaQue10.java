import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class JavaQue10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        System.out.print("Enter the number of integers: ");
        int n = scan.nextInt();
        System.out.println("Enter " + n + " integers:");
        for(int i=0;i<n;i++) 
        {
            numbers.add(scan.nextInt());
        }
        if(n<2) 
        {
            System.out.println("At least two numbers are required");
        } 
        else 
        {
            int secondLargest = findSecondLargest(numbers);
            int secondSmallest = findSecondSmallest(numbers);
            System.out.println("Second largest element: " + secondLargest);
            System.out.println("Second smallest element: " + secondSmallest);
        }
	}
	private static int findSecondLargest(List<Integer> numbers) 
	{
		List<Integer>sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList.get(sortedList.size()-2);
    }
	private static int findSecondSmallest(List<Integer> numbers) 
	{
        List<Integer>sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList.get(1);
    }
}


