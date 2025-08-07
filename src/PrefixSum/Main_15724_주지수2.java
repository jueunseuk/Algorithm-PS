package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15724_주지수2 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        
        int[][] matrix = new int[row+1][col+1];
        
        for(int i = 1; i <= row; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int j = 1; j <= col; j++) {
        		matrix[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int[][] sum = new int[row+1][col+1];
        for(int i = 1; i <= row; i++) {
        	for(int j = 1; j <= col; j++) {
        		sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + matrix[i][j];
        	}
        }
        
        int m = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < m; idx++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int sx = Integer.parseInt(st.nextToken());
        	int sy = Integer.parseInt(st.nextToken());
        	int ex = Integer.parseInt(st.nextToken());
        	int ey = Integer.parseInt(st.nextToken());
        	
        	int answer = sum[ex][ey] - sum[sx - 1][ey] - sum[ex][sy - 1] + sum[sx - 1][sy - 1];
        	
        	sb.append(answer+"\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}