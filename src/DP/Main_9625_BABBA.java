package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9625_BABBA {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[n+1][2];
		
		dp[0][0] = 1;
		dp[0][1] = 0;
		
		for(int i = 1; i <= n; i++) {
			dp[i][0] = dp[i-1][1];
			dp[i][1] = dp[i-1][0] + dp[i-1][1];
		}
		
		System.out.println(dp[n][0]+" "+dp[n][1]);
	}

}
