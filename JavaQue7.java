import java.util.Scanner;
public class JavaQue7 {

	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.println("Enter the target element to be searched: ");
		Scanner sc=new Scanner(System.in);
		int target=sc.nextInt();
		int low=0;
		int high=a.length-1;
		while(low<=high)
		{
			int mid=(low+high)/2;
			if(target==a[mid])
			{
				System.out.println("Target element "+ target+ " found at index "+mid);
				break;
			}
			else if(target<a[mid])
			{
				high=mid-1;
			}
			else if(target>a[mid])
			{
				low=mid+1;
			}
		}
		if(low>high)
		{
			System.out.println("Target element not found");
		}
	}
}
