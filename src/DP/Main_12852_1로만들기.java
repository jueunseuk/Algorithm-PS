package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12852_1로만들기 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[n+1];
		int path[] = new int[n+1];
		
		dp[1] = 0;
		
		for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            path[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                path[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                path[i] = i / 3;
            }
        }

		System.out.println(dp[n]);
		
		StringBuilder sb = new StringBuilder();
        int current = n;
        while (current > 0) {
            sb.append(current).append(" ");
            current = path[current];
        }
        
        System.out.println(sb.toString().trim());
	}

}
