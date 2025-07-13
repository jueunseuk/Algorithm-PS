package Greedy;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17175_피보나치수는지겨웡 {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[n+1];
		
		dp[0] = 1;
		if(n >=1)
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1]+dp[i-2]+1)%MOD;
		}
		
		System.out.println(dp[n]);
	}

}
