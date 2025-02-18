import java.util.ArrayList;

public class Zeckendorf {
    public static int fibonacciZeckendorf(int n) {
        if (n == 0 || n == 1) return n;

        // Step 1: Generate Fibonacci numbers up to n
        ArrayList<Integer> fibList = new ArrayList<>();
        fibList.add(0);
        fibList.add(1);
        while (fibList.get(fibList.size() - 1) + fibList.get(fibList.size() - 2) <= n) {
            fibList.add(fibList.get(fibList.size() - 1) + fibList.get(fibList.size() - 2));
        }

        // Step 2: Compute Fibonacci sum using Zeckendorf representation
        int result = 0;
        while (n > 0) {
            // Find the largest Fibonacci number <= n
            int idx = fibList.size() - 1;
            while (fibList.get(idx) > n) {
                idx--;
            }

            result += fibList.get(idx);
            n -= fibList.get(idx);

            // Skip next Fibonacci number to prevent consecutive selection
            idx--;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] testValues = {501, 631, 794, 1000, 1259, 1585, 1995, 2512, 3162, 3981, 5012, 6310, 7943, 10000, 12589, 15849};
        double[][] times = new double[3][testValues.length]; // Store execution times

        // JVM Warm-up (Ensures accurate timing)
        for (int n : testValues) {
            fibonacciZeckendorf(n);
        }

        // Measure execution time
        for (int run = 0; run < 3; run++) {
            for (int i = 0; i < testValues.length; i++) {
                int n = testValues[i];

                long start = System.nanoTime(); // Start timer
                fibonacciZeckendorf(n);
                long end = System.nanoTime(); // End timer

                times[run][i] = (end - start) / 1_000_000_000.0; // Convert nanoseconds to seconds
            }
        }

        // Print table header
        System.out.print("Run \\ n  ");
        for (int n : testValues) {
            System.out.printf("%-9d", n);
        }
        System.out.println("\n" + "-".repeat(testValues.length * 10));

        // Print results in a formatted table
        for (int run = 0; run < 3; run++) {
            System.out.printf("%-7d", (run + 1));
            for (int i = 0; i < testValues.length; i++) {
                System.out.printf("%-9.6f", times[run][i]);
            }
            System.out.println();
        }
    }
}
