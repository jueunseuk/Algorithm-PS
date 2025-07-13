package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_1793_타일링 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger[] dp = new BigInteger[251];
		
		dp[0] = new BigInteger("0");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		
		for(int i = 3; i <= 250; i++) {
			dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));
		}
		
		String input;
		while((input = br.readLine()) != null && !input.isEmpty()) {
			int n = Integer.parseInt(input);
			if(n == 0)
				System.out.println(1);
			else
				System.out.println(dp[n]);
		}
	}

}
