package Graph.FloydWarshall;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_23286_허들넘기 {
	static final int INF = 1000000000;
	static int n, m, query;
	static int[][] result;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        query = Integer.parseInt(st.nextToken());
        
        result = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
        	Arrays.fill(result[i], INF);
        	result[i][i] = 0;
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	result[start][end] = c;
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], Math.max(result[i][k], result[k][j]));
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < query; q++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	if(result[start][end] == INF) {
        		sb.append(-1);
        	} else {
        		sb.append(result[start][end]);
        	}
        	
        	sb.append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

}
