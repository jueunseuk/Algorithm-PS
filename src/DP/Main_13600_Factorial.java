package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_13600_Factorial {
	static int[] dp = new int[9];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        make();
        
        int cnt = 0, idx = 8;
        while(n > 0) {
        	if(n >= dp[idx]) {
        		n -= dp[idx];
        		cnt++;
        	} else {
        		idx--;
        	}
        }
        
        System.out.println(cnt);

	}

	private static void make() {
		dp[1] = 1;
		for(int i = 2; i <= 8; i++) {
			dp[i] = dp[i-1]*i;
		}
	}

}
