package Graph.FloydWarshall;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956_운동 {
	static final int INF = 1000000000;
	
	static int n, m;
	static int[][] result;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        result = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	result[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k]+result[k][j]);
        		}
        	}
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
        	for(int j = i+1; j <= n; j++) {
        		if(result[i][j] == INF || result[j][i] == INF) continue;
        		
        		min = Math.min(min, result[i][j]+result[j][i]);
        	}
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
}