package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_13976_3n타일채우기2 {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 != 0) {
            System.out.println(0);
            return;
        }

        n /= 2;

        long[][] base = {
                {3, 2, 0},
                {1, 0, 0},
                {0, 1, 0}
        };

        long[][] resultMatrix = matrixPower(base, n - 1);

        long[] initial = {3, 1, 0};

        long dp = (resultMatrix[0][0] * initial[0] % MOD
                 + resultMatrix[0][1] * initial[1] % MOD
                 + resultMatrix[0][2] * initial[2] % MOD) % MOD;

        System.out.println(dp);
    }

    public static long[][] matrixPower(long[][] matrix, int exp) {
        int size = matrix.length;
        long[][] result = new long[size][size];
        for (int i = 0; i < size; i++) {
            result[i][i] = 1;
        }

        while (exp > 0) {
            if (exp % 2 == 1) {
                result = multiplyMatrix(result, matrix);
            }
            matrix = multiplyMatrix(matrix, matrix);
            exp /= 2;
        }
        return result;
    }

    public static long[][] multiplyMatrix(long[][] a, long[][] b) {
        int size = a.length;
        long[][] result = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j] % MOD) % MOD;
                }
            }
        }
        return result;
    }
}
