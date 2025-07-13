package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11727_2n타일링2 {
	static final int MOD = 10007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		if(n >= 2) {
			dp[2] = 3;
		}
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1]+dp[i-2]*2)%MOD;
		}
		
		System.out.println(dp[n]);
	}

}
