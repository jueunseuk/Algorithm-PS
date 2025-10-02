package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9465_스티커 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	int[][] score = new int[2][n+1];
        	int[][] dp = new int[2][n+1];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int i = 1; i <= n; i++) {
        		score[0][i] = Integer.parseInt(st.nextToken());
        	}
        	
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i = 1; i <= n; i++) {
        		score[1][i] = Integer.parseInt(st.nextToken());
        	}
        	
        	dp[0][1] = score[0][1];
            dp[1][1] = score[1][1];
            
            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + score[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + score[1][i];
            }
            
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}