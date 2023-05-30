import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class JavaQue6 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
        for (int i=1; i<=15; i++) 
        {
            numbers.add(i);
        }
        List<Integer>sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted numbers:" + sortedNumbers);

        List<Integer>filteredNumbers = numbers.stream()
                .filter(num-> num%2 == 0)
                .collect(Collectors.toList());
        System.out.println("Filtered numbers(even):" + filteredNumbers);
    }
}


