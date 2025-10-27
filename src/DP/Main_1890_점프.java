package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1890_점프 {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] matrix = new int[n][n];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(dp[i][j] == 0 || (i == n-1 && j == n-1)) continue; 
                
                int ni = i + matrix[i][j];
                int nj = j + matrix[i][j];
                
                if(ni < n) dp[ni][j] += dp[i][j];
                if(nj < n) dp[i][nj] += dp[i][j];
            }
        }

        System.out.println(dp[n-1][n-1]);
	}
}