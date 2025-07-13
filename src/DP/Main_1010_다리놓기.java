package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 { 
	
	static int N, M; // M개 중에 N개를 뽑음. 순서 신경써서.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int testCase[] = new int[TC];
		
		for(int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
				
			testCase[i] = combination(M, N);
		}
		
		for(int i = 0; i < TC; i++)
		System.out.println(testCase[i]);
		
		br.close();
	}
	
	private static int combination(int n, int k) {
        k = Math.min(k, n-k);
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}