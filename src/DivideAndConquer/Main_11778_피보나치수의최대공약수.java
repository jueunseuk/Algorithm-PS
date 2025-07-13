package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11778_피보나치수의최대공약수 {
	static final int MOD = 1000000007;
	static long[][] origin = {
			{1, 1},
			{1, 0}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			System.out.println(fibo(gcd(a, b)));
		}
		
	}
	
	public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
	
	public static long fibo(long n) {
		if (n == 0) return 0;
        if (n == 1) return 1;
		
		long[][] result = power(origin, n-1);
		
		return result[0][0];
	}
	
	public static long[][] power(long[][] matrix, long n) {
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
