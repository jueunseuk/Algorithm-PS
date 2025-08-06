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

public class Main_17396_백도어 {
	static final long INF = Long.MAX_VALUE/4;
	
	static int n, m, t;
	static List<List<int[]>> list = new ArrayList<>();
	static long[] cost;
	static boolean[] block;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++) {
        	list.add(new ArrayList<>());
        }
        
        block = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
        	if(Integer.parseInt(st.nextToken()) == 1) {
        		block[i] = true;
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	if((block[start] || block[end]) && (start != n-1 && end != n-1)) {
        		continue;
        	}
        	
        	list.get(start).add(new int[] {end, c});
        	list.get(end).add(new int[] {start, c});
        }
        
        dijkstra(n-1, 0);
	}

	private static void dijkstra(int i, int j) {
		Queue<Node> q = new PriorityQueue<>();
		cost = new long[n];
		Arrays.fill(cost, INF);
		
		q.offer(new Node(i, 0));
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.node == j) {
				System.out.println(poll.w);
				return;
			}
			
			if(poll.w > cost[poll.node]) continue;
			
			for(int[] out : list.get(poll.node)) {
				long nc = out[1] + poll.w;
				if(nc < cost[out[0]]) {
					q.offer(new Node(out[0], nc));
					cost[out[0]] = nc;
				}
			}
		}
		
		System.out.println(-1);
	}

	static class Node implements Comparable<Node> {
		int node;
		long w;
		
		public Node(int node, long w) {
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.w, o.w);
		}
	}
}