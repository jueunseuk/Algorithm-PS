package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_14495_피보나치비슷한수열 {
	static long[] dp = new long[117];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        fibo();
        
        int n = Integer.parseInt(br.readLine());
        
        System.out.println(dp[n]);
	}
	
	public static void fibo() {
		dp[1] = dp[2] = dp[3] = 1; 
		for(int i = 4; i < 117; i++) {
			dp[i] = dp[i-1] + dp[i-3];
		}
	}

}
