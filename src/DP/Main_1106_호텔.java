package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1106_호텔 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[][] cost = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 0; i < n; i++) {
            for (int j = cost[i][1]; j < 10001; j++) {
                if (dp[j - cost[i][1]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - cost[i][1]] + cost[i][0]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = C; i < 10001; i++) {
            answer = Math.min(answer, dp[i]);
        }

        System.out.println(answer);
	}
}