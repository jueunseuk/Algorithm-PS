package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14440_정수수열 {
	static final int MOD = 100;
	static int x, y, a0, a1;
	static long[][] origin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		a0 = Integer.parseInt(st.nextToken());
		a1 = Integer.parseInt(st.nextToken());
		long n = Long.parseLong(st.nextToken());
		
		origin = new long[][] {
			{x, 1},
			{y, 0}
		};
		
		String result = String.valueOf(make(n));
		
		System.out.println(result.length() < 2 ? "0"+result : result);
	}
	
	public static long make(long n) {
		if (n == 0) return a0;
        if (n == 1) return a1;
		
		long[][] result = power(origin, n-1);
		
		long answer = result[0][0]*a1 + result[1][0]*a0;
		
		return answer % MOD;
	}
	
	private static long[][] power(long[][] matrix, long n) {
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