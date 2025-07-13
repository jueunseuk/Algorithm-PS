package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_17212_달나라토끼 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int coin[] = {1, 2, 5, 7};
        
        int dp[] = new int[n+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 0; i < 4; i++) {
        	for(int j = coin[i]; j < n+1; j++) {
        		dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
        	}
        }
        
        System.out.println(dp[n]);

	}

}
