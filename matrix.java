import java.util.Scanner;

public class matrix {

    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        result[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        result[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        result[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        result[1][1] = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        return result;
    }

    private static long[][] power(long[][] matrix, int n) {
        long[][] result = { {1, 0}, {0, 1} }; // Единичная матрица
        while (n > 0) {
            if (n % 2 == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            n /= 2;
        }
        return result;
    }

    public static long fibonacci(int n) {
        if (n == 0) return 0;
        long[][] baseMatrix = { {0, 1}, {1, 1} };
        long[][] resultMatrix = power(baseMatrix, n);
        return resultMatrix[0][1]; // Возвращаем F(n)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }
}
