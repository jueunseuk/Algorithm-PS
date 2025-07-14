package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] table = new int[n+1];
		boolean[][] dp = new boolean[n+1][n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= n; i++) {
			table[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int len = 1; len <= n; len++) {
		    for (int start = 1; start + len - 1 <= n; start++) {
		        int end = start + len - 1;

		        if (table[start] == table[end]) {
		            if (len <= 2) {
		                dp[start][end] = true;
		            } else {
		                dp[start][end] = dp[start + 1][end - 1];
		            }
		        }
		    }
		}

		StringBuilder sb = new StringBuilder();
		int query = Integer.parseInt(br.readLine());
		for(int q = 0; q < query; q++) {
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] ? 1 : 0).append("\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}