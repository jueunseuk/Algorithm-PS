package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_30991_ESC {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long dp[][] = new long[n+1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 1;
        
        for(int i = 1; i <= n; i++) {
        	dp[i][0] = dp[i-1][0] - dp[i-1][2];
        	dp[i][1] = dp[i-1][1] + dp[i-1][2];
        	dp[i][2] = dp[i-1][2] + 2*dp[i-1][0] - 2*dp[i-1][1];
        }
        
        System.out.println(dp[n][2]);
	}
}