package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11444_피보나치수6_분할정복 {
	static final int MOD = 1000000007;
	static long[][] origin = {
			{1, 1},
			{1, 0}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		long start = System.nanoTime();
		System.out.println(fibo(n));
		long end = System.nanoTime();
		
		System.out.println((end-start)/1000);
	}
	
	public static long fibo(long n) {
		if (n == 0) return 0;
        if (n == 1) return 1;
		
		long[][] result = power(origin, n-1);
		
		return result[0][0];
	}
	
	private static long[][] power(long[][] matrix, long n) {
		if (n == 0) {
            return new long[][] {{1,0},{0,1}};
        }
        if (n == 1) {
            return matrix;
        }
        
        if (n % 2 == 0) {
            long[][] half = power(matrix, n/2);
            return multiple(half, half);
        } else {
            return multiple(matrix, power(matrix, n-1));
        }
	}

	public static long[][] multiple(long[][] A, long[][] B){
		long[][] multi = new long[2][2];
		
		for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    multi[i][j] += A[i][k] * B[k][j];
                    multi[i][j] %= MOD;
                }
            }
        }
		
		return multi;
	}
}
