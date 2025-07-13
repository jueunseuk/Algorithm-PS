package DP;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10844_쉬운계단수 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(br.readLine());
        
        int dp[][] = new int[length+1][10];
        
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }
        
        for (int i = 2; i <= length; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) dp[i][j] += dp[i - 1][j - 1];
                if (j < 9) dp[i][j] += dp[i - 1][j + 1];
                dp[i][j] %= 1000000000;     
            }
        }
        
        long result = 0;
        for (int j = 0; j <= 9; j++) {
            result += dp[length][j];
        }
        System.out.println(result % 1000000000);
	}

}
