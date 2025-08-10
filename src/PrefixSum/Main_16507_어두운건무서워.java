package PrefixSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16507_어두운건무서워 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int query = Integer.parseInt(st.nextToken());
		
		int[][] origin = new int[row+1][col+1];
		for(int i = 1; i <= row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= col; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] sum = new int[row+1][col+1];
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + origin[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
        for(int idx = 0; idx < query; idx++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int sx = Integer.parseInt(st.nextToken());
        	int sy = Integer.parseInt(st.nextToken());
        	int ex = Integer.parseInt(st.nextToken());
        	int ey = Integer.parseInt(st.nextToken());
        	
        	int answer = sum[ex][ey] - sum[sx - 1][ey] - sum[ex][sy - 1] + sum[sx - 1][sy - 1];
        	int denom = (ex-sx+1) * (ey-sy+1);
        	
        	sb.append(answer/denom).append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}
}