package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20002_사과나무 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] matrix = new int[n][n];
        int[][] sum = new int[n+1][n+1];
        
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 0; j < n; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i-1][j-1];
        	}
        }
        
        int max = Integer.MIN_VALUE;
        for(int size = 0; size < n; size++) {
        	for(int sx = 1; sx <= n-size; sx++) {
        		for(int sy = 1; sy <= n-size; sy++) {
        			int ex = sx+size;
        			int ey = sy+size;
        			max = Math.max(max, sum[ex][ey] - sum[ex][sy-1] - sum[sx-1][ey] + sum[sx-1][sy-1]);
        		}
        	}
        }
        
        System.out.println(max);
	}
}