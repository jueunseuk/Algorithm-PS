package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_23247_Ten {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[row+1][col+1];
		int[][] sum = new int[row+1][col+1];
		
		for(int i = 1; i <= row; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= col; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i][j];
			}
		}
		
		int cnt = 0;
		for(int sx = 1; sx <= row; sx++) {
			for(int ex = sx; ex <= row; ex++) {
				if(ex-sx >= 10) break;
				
				for(int sy = 1; sy <= col; sy++) {
					for(int ey = sy; ey <= col; ey++) {
						if(ey-sy >= 10) break;
						if((ex-sx+1) * (ey-sy+1) > 10) break;
						
						if(sum[ex][ey] - sum[sx-1][ey] - sum[ex][sy-1] + sum[sx-1][sy-1] == 10)
							cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}