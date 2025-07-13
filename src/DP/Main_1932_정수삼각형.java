package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int input[][] = new int[n][];
		int dp[][] = new int[n][];
		
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i] = new int[i+1];
			for(int j = 0; j <= i; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0] = new int[1];
		dp[0][0] = input[0][0];
		
		for (int i = 1; i < n; i++) {
			dp[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + input[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + input[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + input[i][j];
                }
            }
        }
		
		int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }

        System.out.println(max);
		
	}

}
