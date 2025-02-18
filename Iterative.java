import java.math.BigInteger;

public class Iterative {
    public static BigInteger[] fastDoubling(int n) {
        if (n == 0) return new BigInteger[]{BigInteger.ZERO, BigInteger.ONE};

        BigInteger[] fib = fastDoubling(n / 2);
        BigInteger a = fib[0];  // F(k)
        BigInteger b = fib[1];  // F(k+1)
        BigInteger c = a.multiply(b.multiply(BigInteger.TWO).subtract(a));  // F(2k)
        BigInteger d = b.multiply(b).add(a.multiply(a));  // F(2k+1)

        return (n % 2 == 0) ? new BigInteger[]{c, d} : new BigInteger[]{d, c.add(d)};
    }

    public static BigInteger fibonacci(int n) {
        return fastDoubling(n)[0]; // Return only F(n)
    }

    public static void main(String[] args) {
        int[] testValues = {501, 631, 794, 1000, 1259, 1585, 1995, 2512, 3162, 3981, 5012, 6310, 7943, 10000, 12589, 15849};
        double[][] times = new double[3][testValues.length]; // Store execution times

        // JVM Warm-up (Ensures accurate timing)
        for (int n : testValues) {
            fibonacci(n);
        }

        // Measure execution time
        for (int run = 0; run < 3; run++) {
            for (int i = 0; i < testValues.length; i++) {
                int n = testValues[i];

                long start = System.nanoTime(); // Start timer
                fibonacci(n);
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
