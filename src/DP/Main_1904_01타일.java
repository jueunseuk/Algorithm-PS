package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1904_01타일 {
	static final int MOD = 15746;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long dp[] = new long[n+1];
        
        dp[0] = 0;
        if(n >= 1) {
        	dp[1] = 1;
        }
        if(n >= 2) {
        	dp[2] = 2;
        }
        
        for(int i = 3; i <= n; i++) {
        	dp[i] = (dp[i-2]+dp[i-1])%MOD;
        }
        
        System.out.println(dp[n]);
	}

}
