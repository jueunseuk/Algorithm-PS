package Graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5972_택배배송 {
	static int N, M;
	static List<Node>[] adj;
	static int[] dist;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
        	adj[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }
        
        dijkstra();
        
        System.out.println(dist[N]);
        
	}
	
	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		
		dist[1] = 0;
		q.offer(new Node(1, dist[1]));
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			int pollV = poll.v;
			int pollW = poll.w;
			
			if(dist[pollV] < pollW) {
				continue;
			}
			
			for(Node node : adj[pollV]) {
				int newV = node.v;
				int newW = node.w + pollW;
				
				if(dist[newV] > newW) {
					dist[newV] = newW;
					q.offer(new Node(newV, newW));
				}
			}
		}
		
	}

	static class Node implements Comparable<Node> {
        int v, w;
        
        Node(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Node o){
            return this.w - o.w;
        }
    }

}
