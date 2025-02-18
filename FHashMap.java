import java.util.HashMap;
import java.util.Map;

public class FHashMap {
    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fibonacci(int n) {
        if (n <= 1) return n;

        // Bottom-Up DP with HashMap
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
            memo.put(i, b); // Store result in HashMap
        }
        return b;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] testValues = {501, 631, 794, 1000, 1259, 1585, 1995, 2512, 3162, 3981, 5012, 6310, 7943, 10000, 12589, 15849};
        double[][] times = new double[3][testValues.length]; // Store execution times

        for (int run = 0; run < 3; run++) {
            for (int i = 0; i < testValues.length; i++) {
                int n = testValues[i];

                memo.clear(); // Reset memoization
                Thread.sleep(1); // Prevent CPU optimizations

                long start = System.nanoTime(); // Start timer
                fibonacci(n);
                long end = System.nanoTime(); // End timer

                times[run][i] = (end - start) / 1_000_000_000.0; // Convert to seconds
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
