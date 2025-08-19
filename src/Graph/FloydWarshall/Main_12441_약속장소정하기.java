package Graph.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12441_약속장소정하기 {
	static final int INF = 1000000000;
	
	static int n, f, m;
	static int[][] friend;
	static int[][] result;

	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			friend = new int[f+1][2];
			for(int i = 1; i <= f; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				friend[i][0] = Integer.parseInt(st.nextToken());
				friend[i][1] = Integer.parseInt(st.nextToken());
			}
			
			result = new int[n+1][n+1];
			for(int i = 1; i <= n; i++) {
				Arrays.fill(result[i], INF);
				result[i][i] = 0;
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int input = Integer.parseInt(st.nextToken())-1;
				
				int prev = Integer.parseInt(st.nextToken());
				for(int j = 0; j < input; j++) {
					int curr = Integer.parseInt(st.nextToken());
					result[prev][curr] = c;
					result[curr][prev] = c;
					prev = curr;
				}
			}
			
			for(int k = 1; k <= n; k++) {
				for(int i = 1; i <= n; i++) {
					for(int j = 1; j <= n; j++) {
						result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i = 1; i <= n; i++) {
				int max = 0;
				boolean flag = true;
				
				for(int j = 1; j <= f; j++) {
					if(result[i][friend[j][0]] == INF) {
						flag = false;
						break;
					}
					
					max = Math.max(max, result[i][friend[j][0]] * friend[j][1]);
				}
				
				if(flag) min = Math.min(min, max);
			}
			
			print(t+1, min);
		}

		System.out.println(sb.toString().trim());
	}

	private static void print(int idx, int min) {
		sb.append("Case #").append(idx).append(": ").append(min == Integer.MAX_VALUE ? -1 : min).append("\n");
	}
}