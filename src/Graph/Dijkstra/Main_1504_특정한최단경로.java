package Graph.Dijkstra;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	static final int INF = 1_000_000_000;
	
	static int n, m;
	static List<List<Node>> list = new ArrayList<>();
	static int[] dist;
	
	static int[] condition = new int[2];

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int cost = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(new Node(end, cost));
        	list.get(end).add(new Node(start, cost));
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        condition[0] = Integer.parseInt(st.nextToken());
        condition[1] = Integer.parseInt(st.nextToken());
        
        int method1_1 = dijkstra(1, condition[0]);
        int method1_2 = dijkstra(condition[1], n);
        int method2_1 = dijkstra(1, condition[1]);
        int method2_2 = dijkstra(condition[0], n);
        int bridge = dijkstra(condition[0], condition[1]);
        
        int result = Math.min(method1_1+method1_2+bridge, method2_1+method2_2+bridge);
        
        if(result == INF || result < 0) {
        	System.out.println(-1);
        } else {
        	System.out.println(result);
        }
	}

	private static int dijkstra(int i, int target) {
		Queue<Node> q = new PriorityQueue<>();
		dist = new int[n+1];
        Arrays.fill(dist, INF);
		
		q.offer(new Node(i, 0));
		dist[i] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.node == target) {
				return poll.weight;
			}
			
			for(Node out : list.get(poll.node)) {
				if(dist[out.node] > out.weight+poll.weight) {
					dist[out.node] = out.weight+poll.weight;
					q.offer(new Node(out.node, out.weight+poll.weight));
				}
			}
		}
		
		return dist[target];
	}

	public static class Node implements Comparable<Node>{
		int node, weight;
		
		public Node(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}