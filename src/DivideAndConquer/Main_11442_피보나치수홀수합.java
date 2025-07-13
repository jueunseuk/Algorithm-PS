package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11442_피보나치수홀수합 {
	static final int MOD = 1000000000;
	static long[][] origin = {
			{1, 1},
			{1, 0}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < tc; i++) {
			System.out.println(fibo(Long.parseLong(br.readLine())));
		}
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
		
		multi[0][0] = (A[0][0]*B[0][0] + A[0][1]*B[1][0])%MOD;
		multi[0][1] = (A[0][0]*B[0][1] + A[0][1]*B[1][1])%MOD;
		multi[1][0] = (A[1][0]*B[0][0] + A[1][1]*B[1][0])%MOD;
		multi[1][1] = (A[1][0]*B[0][1] + A[1][1]*B[1][1])%MOD;
		
		return multi;
	}
}
