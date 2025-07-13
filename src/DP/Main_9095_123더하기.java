package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095_123더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int number[] = new int[T];
		int max = 0;
		
		for(int i = 0; i < T; i++) {
			number[i] = Integer.parseInt(br.readLine());
			if(number[i] > max) max = number[i];
		}
		
		int dp[] = new int[max+1];
	
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= max; i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		for(int i = 0; i < T; i++)
		System.out.println(dp[number[i]]);
	}

}
