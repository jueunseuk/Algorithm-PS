package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2410_2의멱수의합 {
	static final int MOD = 1000000000;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int []dp = new int[n+1];
        
        dp[1] = 1;
        if(n >= 2)
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
        	if(i % 2 == 1) {
        		dp[i] = dp[i-1];
        	} else {
        		dp[i] = (dp[i-1]+dp[i/2])%MOD;
        	}
        }
        
        System.out.println(dp[n]);
	}

}
