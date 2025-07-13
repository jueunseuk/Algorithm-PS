package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1865_웜홀 {
	static final int INF = 100000000;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int hole = Integer.parseInt(st.nextToken());
        	
        	List<Edge> list = new ArrayList<>();
        	int cost[] = new int[n+1];
        	
        	Arrays.fill(cost, INF);
        	cost[1] = 0;
        	
        	for(int i = 0; i < m; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int start = Integer.parseInt(st.nextToken());
        		int end = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		
        		list.add(new Edge(start, end, c));
        		list.add(new Edge(end, start, c));
        	}
        	
        	for(int i = 0; i < hole; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken())));
        	}
        	
        	for(int i = 0; i < n-1; i++) {
        		boolean flag = false;
        		
        		for(Edge out : list) {
        			if(cost[out.start] != INF && cost[out.start] + out.w < cost[out.end]) {
        				cost[out.end] = cost[out.start] + out.w;
        				flag = true;
        			}
        		}
        		
        		if(!flag) {
        			break;
        		}
        	}
        	
        	boolean flag = false;
        	for(Edge out : list) {
    			if(cost[out.start] != INF && cost[out.start] + out.w < cost[out.end]) {
    				flag = true;
    			}
    		}
        	sb.append(flag ? "YES" : "NO").append("\n");
        }
        
        System.out.println(sb.toString().trim());
	}

	public static class Edge {
		int start, end, w;
		
		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}
	}
}