package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15712_등비수열의합 {
    static long a, r, n, MOD;
    static long[][] origin = new long[2][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        a = Long.parseLong(st.nextToken());
        r = Long.parseLong(st.nextToken());
        n = Long.parseLong(st.nextToken());
        MOD = Long.parseLong(st.nextToken());
        
        origin[0][0] = r; 
        origin[0][1] = 0;
        origin[1][0] = r; 
        origin[1][1] = 1;
        
        if (n == 1) {
            System.out.println(a % MOD);
            return;
        }
        
        long[][] result = power(origin, n-1);
        
        long Sn = (result[1][0] * a + result[1][1] * a) % MOD;
        
        System.out.println(Sn);
    }
    
    private static long[][] power(long[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }
        
        long[][] half = power(matrix, exp / 2);
        long[][] halfSquared = multiply(half, half);
        
        if (exp % 2 == 0) {
            return halfSquared;
        } else {
            return multiply(matrix, halfSquared);
        }
    }
    
    private static long[][] multiply(long[][] A, long[][] B) {
        long[][] result = new long[2][2];
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        
        return result;
    }
}
