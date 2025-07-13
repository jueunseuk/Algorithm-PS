package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_13301_타일장식물 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        long[] dp = new long[n+1];
        dp[0] = 2;
        dp[1] = 4;
        
        for(int i = 2; i <= n; i++) {
        	dp[i] = dp[i-1]+dp[i-2];
        }
        
        System.out.println(dp[n]);
	}

}
