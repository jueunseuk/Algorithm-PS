package DivideAndConquer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5095_MatrixPower {
	static int size;
	static int MOD;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine(), " ");
			
			size = Integer.parseInt(st.nextToken());
			MOD = Integer.parseInt(st.nextToken());
			int exp = Integer.parseInt(st.nextToken());
			
			if(size == 0 && MOD == 0 && exp == 0) {
				return;
			}
			
			long[][] origin = new long[size][size];
			for(int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < size; j++) {
					origin[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			long result[][] = fibo(origin, exp);
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					sb.append(result[i][j]%MOD);
					if(j < size - 1) {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString().trim());
			System.out.println();
		}
		
	}

	
	private static long[][] fibo(long[][] matrix, int exp) {
        if (exp == 1) return matrix;
		
		long[][] result = power(matrix, exp);
		
		return result;
	}


	private static long[][] power(long[][] matrix, int exp) {
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


	public static long[][] multiple(long[][] A, long[][] B){
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
}
