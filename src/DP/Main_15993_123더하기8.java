package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15993_123더하기8 {
	static final int MOD = 1000000009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp  = new int[100001][2];
		
		dp[1][0] = 1;
		dp[1][1] = 0;
		dp[2][0] = 1;
		dp[2][1] = 1;
		dp[3][0] = 2;
		dp[3][1] = 2;
		
		for(int i = 4; i <= 100000; i++) {
			dp[i][0] = ((dp[i-1][1]+dp[i-2][1])%MOD+dp[i-3][1])%MOD;
			dp[i][1] = ((dp[i-1][0]+dp[i-2][0])%MOD+dp[i-3][0])%MOD;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(dp[input][0]).append(" ").append(dp[input][1]).append("\n");
		}
		
		System.out.println(sb.toString().trim());

	}

}
