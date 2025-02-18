
import java.util.Scanner;

public class dynamic_programming {
    public static int fibonacci(int n) {
        if (n <= 1) return n; // Базовые случаи

        int[] dp = new int[n + 1]; // Создаем массив для хранения значений Фибоначчи
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // Основное рекуррентное соотношение
        }

        return dp[n]; // Возвращаем n-е число Фибоначчи
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
        scanner.close();
    }
}
