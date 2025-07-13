package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11333_4n타일채우기 {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        long dp[] = new long[10001];
        
        dp[3] = 3;
        dp[6] = 13;
        
        for(int i = 9; i < 10001; i++) {
        	if(i % 3 == 0) {
        		dp[i] += (dp[i-3]*3)%MOD;
        		int multi = 4;
        		for(int j = i-6; j > 0; j-= 3) {
        			dp[i] = (dp[i] + (dp[j] * multi) % MOD) % MOD;
        			multi += 2;
        		}
        		dp[i] += (i/3*2) % MOD;
        	}
        }

        for(int t = 0; t < T; t++) {
        	System.out.println(dp[Integer.parseInt(br.readLine())]);
        }
	}

}
