package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13424_비밀모임 {
	static final int INF = 1000000000;
	
	static int n, m;
	static int[][] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			result = new int[n+1][n+1];
			for(int i = 0; i <= n; i++) {
				Arrays.fill(result[i], INF);
				result[i][i] = 0;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				result[start][end] = c;
				result[end][start] = c;
			}
			
			for(int k = 1; k <= n; k++) {
				for(int i = 1; i <= n; i++) {
					for(int j = 1; j <= n; j++) {
						result[i][j] = Math.min(result[i][j], result[i][k]+result[k][j]);
					}
				}
			}
			
			int f = Integer.parseInt(br.readLine());
			int friends[] = new int[f];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < f; i++) {
				friends[i] = Integer.parseInt(st.nextToken());
			}
			
			int node = -1;
			int min = Integer.MAX_VALUE;
			for(int i = 1; i <= n; i++) {
				int sum = 0;
				
				for(int out : friends) {
					sum += result[i][out];
				}
				
				if(min > sum) {
					min = sum;
					node = i;
				}
			}
			
			sb.append(node+"\n");
		}
		
		System.out.println(sb.toString().trim());
	}
}