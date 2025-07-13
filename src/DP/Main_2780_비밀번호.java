package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2780_비밀번호 {
	static final int MOD = 1234567;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        int dp[][] = new int[1001][10];
        
        for(int i = 0; i < 10; i++) {
        	dp[1][i] = 1;
        }
        
        for(int i = 2; i <= 1000; i++) {
        	dp[i][1] = (dp[i-1][2] + dp[i-1][4]) % MOD;
        	dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][5]) % MOD;
        	dp[i][3] = (dp[i-1][2] + dp[i-1][6]) % MOD;
        	dp[i][4] = (dp[i-1][1] + dp[i-1][5] + dp[i-1][7]) % MOD;
        	dp[i][5] = (dp[i-1][2] + dp[i-1][4] + dp[i-1][6] + dp[i-1][8]) % MOD;
        	dp[i][6] = (dp[i-1][3] + dp[i-1][5] + dp[i-1][9]) % MOD;
        	dp[i][7] = (dp[i-1][0] + dp[i-1][4] + dp[i-1][8]) % MOD;
        	dp[i][8] = (dp[i-1][5] + dp[i-1][7] + dp[i-1][9]) % MOD;
        	dp[i][9] = (dp[i-1][6] + dp[i-1][8]) % MOD;
        	dp[i][0] = (dp[i-1][7]) % MOD;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	int length = Integer.parseInt(br.readLine());
        	
        	int sum = 0;
        	for(int i = 0; i < 10; i++) {
        		sum += dp[length][i];
        	}
        	
        	sb.append(sum%MOD).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}