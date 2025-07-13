package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1219_오민식의고민 {
	static final int INF = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Edge> list = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(u, v, c));
            adj.get(u).add(v);
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        int earn[] = new int[n];
        for(int i = 0; i < n; i++) {
        	earn[i] = Integer.parseInt(st.nextToken());
        }
        
        long dist[] = new long[n+1];
        Arrays.fill(dist, INF);
        dist[start] = earn[start];
        
        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (Edge e : list) {
                if (dist[e.start] == INF) continue;
                long next = dist[e.start] + earn[e.end] - e.w;
                if (next > dist[e.end]) {
                    dist[e.end] = next;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        
        if(dist[end] == INF) {
        	System.out.println("gg");
        	return;
        }
        
        boolean[] inCycle = new boolean[n];
        for (Edge e : list) {
            if (dist[e.start] == INF) continue;
            if (dist[e.start] + earn[e.end] - e.w > dist[e.end]) {
                inCycle[e.end] = true;
            }
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (inCycle[i]) q.add(i);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == end) {
                System.out.println("Gee");
                return;
            }
            for (int nxt : adj.get(cur)) {
                if (!inCycle[nxt]) {
                    inCycle[nxt] = true;
                    q.add(nxt);
                }
            }
        }
        
        System.out.println(dist[end]);
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