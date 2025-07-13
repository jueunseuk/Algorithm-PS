package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4172_logsinsqrt {
	static final int MOD = 1000000;
	static int dp[] = new int[1000001];

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        create();
        
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int input = Integer.parseInt(br.readLine());
        	
        	if(input == -1) {
        		break;
        	}
        	
        	sb.append(dp[input]).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	private static void create() {
		dp[0] = 1;
		
		for(int i = 1; i < 1000001; i++) {
			dp[i] = (dp[i] + dp[(int) Math.floor(i-Math.sqrt(i))]) % MOD;
			dp[i] = (dp[i] + dp[(int) Math.floor(Math.log(i))]) % MOD;
			dp[i] = (dp[i] + dp[(int) Math.floor(i * Math.sin(i) * Math.sin(i))]) % MOD;
		}
		
	}

}
