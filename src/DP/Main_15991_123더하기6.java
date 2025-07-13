package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_15991_123더하기6 {
	static final int MOD = 1000000009;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int dp[] = new int[500001];
		int dp2[] = new int[100001];
	
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		dp2[1] = 1;
		dp2[2] = 2;
		dp2[3] = 2;		
		
		for(int i = 4; i <= 50000; i++) {
			dp[i] = ((dp[i-1]+dp[i-2]) % MOD +dp[i-3]) % MOD;
		}
		
		for(int i = 4; i <= 100000; i++) {
			if(i % 2 == 0) {
				dp2[i] = (dp[i/2] + dp[(i-2)/2]) % MOD;
			} else {
				dp2[i] = (dp[(i-1)/2] + dp[(i-3)/2]) % MOD;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			sb.append(dp2[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}