package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13246_행렬제곱의합 {
	static final int MOD = 1000;
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		size = Integer.parseInt(st.nextToken());
		long exp = Long.parseLong(st.nextToken());
		
		long[][] origin = new long[size][size];
		for(int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < size; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long answer[][] = new long[size][size];
		
		for(long i = exp; i > 0; i--) {
			long temp[][] = fibo(origin, i);
			answer = sum(temp, answer);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				sb.append(answer[i][j]%MOD);
				if(j < size - 1) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString().trim());
		
	}

	public static long[][] fibo(long[][] matrix, long exp) {
        if (exp == 1) return matrix;
		
		long[][] result = power(matrix, exp);
		
		return result;
	}


	public static long[][] power(long[][] matrix, long exp) {
		if (exp == 1) {
            return matrix;
        }
        
        if (exp % 2 == 0) {
            long[][] half = power(matrix, exp/2);
            return multiple(half, half);
        } else {
            return multiple(matrix, power(matrix, exp-1));
        }
	}


	public static long[][] multiple(long[][] A, long[][] B) {
		long[][] multi = new long[size][size];
		
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    multi[i][j] += A[i][k] * B[k][j];
                    multi[i][j] %= MOD;
                }
            }
        }
		
		return multi;
	}
	
	public static long[][] sum(long[][] A, long[][] B) {
		long[][] sum = new long[size][size];
		
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
            	sum[i][j] += (A[i][j]+B[i][j]) % MOD;
            }
        }
		
		return sum;
	}
}
