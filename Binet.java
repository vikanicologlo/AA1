import java.util.Scanner;

public class Binet {
    public static double fibonacci(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2; // Golden ratio

        return Math.round(Math.pow(phi, n) / sqrt5); // Rounding to the nearest integer
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Fibonacci(" + n + ") = " + (int) fibonacci(n));
    }
}
