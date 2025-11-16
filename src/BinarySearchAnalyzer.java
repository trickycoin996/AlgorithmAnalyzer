import java.util.Arrays;
import java.util.Random;

public class BinarySearchAnalyzer {

    // Main Method – runs binary search for different array sizes
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            // Random Value Generator
            int[] arr = generateRandomArray(size);   
            // Sort array for binary search
            Arrays.sort(arr);                        
            // Pick random target
            int target = arr[new Random().nextInt(size)]; 

            long start = System.nanoTime();
            // Binary Search execution
            binarySearch(arr, target);               
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f%n", size, timeMs);
        }
    }

    // Random Value Generator – creates an array filled with random integers
    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(1000);
        return arr;
    }

    // Binary Search Method – searches for the target in a sorted array
    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
