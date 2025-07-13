package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15990_123더하기5 {
	static final int MOD = 1000000009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] dp  = new int[100001][3];
		
		dp[1] = new int[] {1, 0, 0};
		dp[2] = new int[] {0, 1, 0};
		dp[3] = new int[] {1, 1, 1};
		
		for(int i = 4; i < 100001; i++) {
			dp[i][0] = (dp[i-1][1]+dp[i-1][2])%MOD;
			dp[i][1] = (dp[i-2][0]+dp[i-2][2])%MOD;
			dp[i][2] = (dp[i-3][0]+dp[i-3][1])%MOD;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(((dp[input][0]+dp[input][1])%MOD+dp[input][2])%MOD).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

}
