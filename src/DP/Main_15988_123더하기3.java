package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15988_123더하기3 {
	static final int MOD = 1000000009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[] dp  = new int[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <=1000000; i++) {
			dp[i] = ((dp[i-1] + dp[i-2]) % MOD + dp[i-3]) % MOD;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}

}
