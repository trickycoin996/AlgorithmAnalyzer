import java.util.Random;

public class BubbleSortAnalyzer {
   public BubbleSortAnalyzer() {
   }

   public static void main(String[] var0) {
      int[] var1 = new int[]{100, 500, 1000};
      System.out.println("Algorithm: Bubble Sort");
      System.out.println("Input Size | Time (ms)");
      System.out.println("----------------------");
      int[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var2[var4];
         int[] var6 = generateRandomArray(var5);
         long var7 = System.nanoTime();
         bubbleSort(var6);
         long var9 = System.nanoTime();
         double var11 = (double)(var9 - var7) / 1000000.0;
         System.out.printf("%-10d | %.4f%n", var5, var11);
      }

   }

   static int[] generateRandomArray(int var0) {
      Random var1 = new Random();
      int[] var2 = new int[var0];

      for(int var3 = 0; var3 < var0; ++var3) {
         var2[var3] = var1.nextInt(1000);
      }

      return var2;
   }

   static void bubbleSort(int[] var0) {
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1 - 1; ++var2) {
         for(int var3 = 0; var3 < var1 - var2 - 1; ++var3) {
            if (var0[var3] > var0[var3 + 1]) {
               int var4 = var0[var3];
               var0[var3] = var0[var3 + 1];
               var0[var3 + 1] = var4;
            }
         }
      }

   }
}
