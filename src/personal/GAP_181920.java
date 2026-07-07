package personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GAP_181920 {
	static final int INF = 100000000;
	public static void main(String[] args) throws IOException {
        BufferedReader br = 
        		new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int [][] result = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	result[start][end] = cost;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			if(result[i][k] != INF && result[k][j] != INF) {
                        result[i][j] = 
                    		Math.min(
                				result[i][j], result[i][k] + result[k][j]
                						);
                    }
        		}
        	}
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		sb.append(result[i][j]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}