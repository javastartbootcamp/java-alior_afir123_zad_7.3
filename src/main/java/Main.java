import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Queue<Integer> numbers = getIntegers();
        Map<Integer, Integer> sortedOccurrences = countOccurrences(numbers);
        printSortedCountOccurrences(sortedOccurrences);
    }

    private static Queue<Integer> getIntegers() throws FileNotFoundException {
        File inputFile = new File("liczby.txt");
        Scanner scanner = new Scanner(inputFile);

        Queue<Integer> numbers = new LinkedList<>();

        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }

    private static Map<Integer, Integer> countOccurrences(Queue<Integer> numbers) {
        Map<Integer, Integer> sortedOccurrences = new TreeMap<>();
        for (Integer number : numbers) {
            if (sortedOccurrences.containsKey(number)) {
                sortedOccurrences.put(number, sortedOccurrences.get(number) + 1);
            } else {
                sortedOccurrences.put(number, 1);
            }
        }
        return sortedOccurrences;
    }

    private static void printSortedCountOccurrences(Map<Integer, Integer> sortedOccurrences) {
        for (Map.Entry<Integer, Integer> entry : sortedOccurrences.entrySet()) {
            System.out.println(entry.getKey() + " - liczba wystąpień " + entry.getValue());
        }
    }

}