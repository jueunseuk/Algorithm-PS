package Graph.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기 {
	static final int INF = 1000000000;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] result = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m ; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = 1;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
                	result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                }
            }
        }
        
        int answer = 0;
        int mid = (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            int h = 0;
            int l = 0;

            for (int j = 1; j <= n; j++) {
                if (result[i][j] != INF && i != j) l++;
                if (result[j][i] != INF && i != j) h++;
            }

            if (h >= mid || l >= mid) answer++;
        }

        System.out.println(answer);
	}
}