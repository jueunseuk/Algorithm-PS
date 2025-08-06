package Graph.FloydWarshall;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13141_Ignition {
	static final int INF = 100000000;
	static int n, m;
	static int[][] result;
	static List<Edge> list = new ArrayList<>();

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
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	list.add(new Edge(start, end, c));
        	if(result[start][end] != INF) {
        		result[start][end] = Math.min(result[start][end], c);
        	} else {
        		result[start][end] = c;
        	}
        	if(result[end][start] != INF) {
        		result[end][start] = Math.min(result[start][end], c);
        	} else {
        		result[end][start] = c;
        	}
        }
        
        for(int k = 1; k <= n; k++) {
        	for(int i = 1; i <= n; i++) {
        		for(int j = 1; j <= n; j++) {
        			result[i][j] = Math.min(result[i][j], result[i][k]+result[k][j]);
        		}
        	}
        }
        
        double min = Double.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            double take = 0;
            for(Edge out : list){
                double t = (result[i][out.from] + result[i][out.to] + out.length) / 2.0;
                take = Math.max(t, take);
            }
            min = Math.min(min, take);
        }
        
        System.out.printf("%.1f\n", min);
	}

	static class Edge {
		int from, to, length;

		public Edge(int from, int to, int length) {
			this.from = from;
			this.to = to;
			this.length = length;
		}
	}
}