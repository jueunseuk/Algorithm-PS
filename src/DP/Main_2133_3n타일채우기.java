package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2133_3n타일채우기 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int dp[] = new int[31];
        
        dp[2] = 3;
        dp[4] = 11;
        
        for(int i = 6; i < 31; i++) {
        	if(i % 2 == 0) {
        		dp[i] += dp[i-2]*3;
        		for(int j = i-4; j >= 0; j-= 2) {
        			dp[i] += dp[j]*2;
        		}
        		dp[i] += 2;
        	}
        }

        System.out.println(dp[n]);
	}

}
