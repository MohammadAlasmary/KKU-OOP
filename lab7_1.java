import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaFilterSort {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 25, 8);
        int threshold = 12;

        System.out.println("Original list of numbers: " + numbers);
        System.out.println("Filtering threshold: " + threshold);

        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n >= threshold)
                .collect(Collectors.toList());

        System.out.println("Filtered list (numbers >= " + threshold + "): " + filteredNumbers);

        List<Integer> sortedNumbers = filteredNumbers.stream()
                .sorted((n1, n2) -> Integer.compare(n1, n2))
                .collect(Collectors.toList());

        System.out.println("Sorted list (ascending): " + sortedNumbers);

        System.out.println("Final filtered and sorted list: " + sortedNumbers);

        System.out.println("\n--- Program Execution Log ---");
        System.out.println("Original Input: " + numbers + ", Threshold: " + threshold);
        System.out.println("Filtering Operation: Numbers greater than or equal to " + threshold);
        System.out.println("Sorting Operation: Ascending order");
        System.out.println("Output: " + sortedNumbers);
    }
}
