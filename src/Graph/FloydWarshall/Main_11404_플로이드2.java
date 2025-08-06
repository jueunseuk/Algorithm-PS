package Graph.FloydWarshall;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404_플로이드2 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int node = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int [][]adj = new int[node+1][node+1];
        
        for(int i = 0; i <= node; i++) {
        	Arrays.fill(adj[i], 100_000_000);
        	adj[i][i] = 0;
        }
        
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	adj[start][end] = cost;
        	adj[end][start] = cost;
        }
        
        for(int k = 1; k <= node; k++) {
        	System.out.println("test case "+k);
        	for(int i = 1; i <= node; i++) {
        		for(int j = 1; j <= node; j++) {
    				adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
        		}
        	}
        	StringBuilder sb = new StringBuilder();
        	for(int i = 1; i <= node; i++) {
        		for(int j = 1; j <= node; j++) {
        			if(adj[i][j] == 100_000_000) sb.append(0+" ");
        			else sb.append(adj[i][j]+" ");
        		}
        		sb.deleteCharAt(sb.length()-1).append("\n");
        	}
        	
        	System.out.println(sb.toString().trim());
        	System.out.println();
        }
        
	}
}