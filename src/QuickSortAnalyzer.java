import java.util.Random;

public class QuickSortAnalyzer {

    // Main Method – runs quick sort for different array sizes
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("Algorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            // Random Value Generator
            int[] arr = generateRandomArray(size);   

            long start = System.nanoTime();
            // Quick Sort execution
            quickSort(arr, 0, arr.length - 1);       
            long end = System.nanoTime();

            double timeMs = (end - start) / 1_000_000.0;
            System.out.printf("%-10d | %.4f%n", size, timeMs);
        }
    }

    // Random Value Generator – creates random integer arrays
    static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
            arr[i] = rand.nextInt(1000);
        return arr;
    }

    // Quick Sort Method – recursive sorting algorithm
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition Method – divides the array around a pivot
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
