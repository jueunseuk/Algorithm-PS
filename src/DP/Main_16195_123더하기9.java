package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16195_123더하기9 {
	static final int MOD = 1000000009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[1001][];
		
		dp[1] = new int[2];
		dp[1][1] = 1;
		dp[2] = new int[3];
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3] = new int[4];
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
		
		for(int i = 4; i < 1001; i++) {
			dp[i] = new int[i+1];
			for(int j = 1; j <= i; j++) {
				if(j <= i-2) {
					dp[i][j] = ((dp[i-1][j-1] + dp[i-2][j-1]) % MOD + dp[i-3][j-1]) % MOD;
				} else if(j <= i-1) {
					dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1]) % MOD;
				} else {
					dp[i][j] = 1;
				}
			}
		}
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int target = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			
			int result = 0;
			
			for(int i = 1; i <= limit; i++) {
				result = (result+dp[target][i]) % MOD;
			}
			
			sb.append(result).append("\n");
		}
		
		br.close();
		
		System.out.println(sb.toString().trim());

	}

}
