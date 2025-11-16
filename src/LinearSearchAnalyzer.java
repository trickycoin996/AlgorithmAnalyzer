import java.util.Random;

public class LinearSearchAnalyzer {

    // Main Method – runs linear search for different array sizes
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            // Random Value Generator
            int[] arr = generateRandomArray(size);   
            // Pick a random target value
            int target = arr[new Random().nextInt(size)]; 

            long start = System.nanoTime();
            // Linear Search execution
            linearSearch(arr, target);               
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

    // Linear Search Method – searches for the target in the array
    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }
}
