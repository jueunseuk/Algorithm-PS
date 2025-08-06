package Graph.BellmanFord;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_Bellman_Ford {
	static final int INF = 100000000;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Edge> list = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        long dist[] = new long[n+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        for(int i = 0; i < n-1; i++) {
        	boolean changed = false;
        	
        	for(Edge out : list) {
        		if(dist[out.start] != INF && dist[out.start] + out.w < dist[out.end]) {
        			dist[out.end] = dist[out.start] + out.w;
        			changed = true;
        		}
        	}
        	
        	if(!changed) break;
        }
        
        for(Edge out : list) {
    		if(dist[out.start] != INF && dist[out.start] + out.w < dist[out.end]) {
    			System.out.println(-1);
    			return;
    		}
    	}
        
        for(int i = 1; i <= n; i++) {
        	System.out.println("1번 노드에서 "+i+"번 노드까지의 최소 비용 : "+dist[i]);
        }
        
	}
	
	static class Edge {
		int start, end, w;
		
		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}
}