package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11952_좀비 {
	static final long INF = 10000000000000000l;
	
	static int n, m, d, range;
	static long costp, costq;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] danger;
	static int[] state;
	static long[] cost;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        range = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        costp = Long.parseLong(st.nextToken());
        costq = Long.parseLong(st.nextToken());
        
        danger = new int[d];
        for(int i = 0; i < d; i++) {
        	danger[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i <= n; i++) {
        	list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	
        	list.get(start).add(end);
        	list.get(end).add(start);
        }
        
        
        bfs();
        
        dijkstra(1, n);
	}

	public static void dijkstra(int i, int j) {
		Queue<Node> q = new PriorityQueue<>();
		cost = new long[n+1];
		Arrays.fill(cost, INF);
		
		q.offer(new Node(i, 0));
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.node == j) {
				if(state[poll.node] == 1) poll.w -= costq;
				else poll.w -= costp;
				System.out.println(poll.w);
				return;
			}
			
			if(poll.w > cost[poll.node]) continue;
			
			for(int out : list.get(poll.node)) {
				if(state[out] == 2) continue;
				
				long nc = poll.w;
				if(state[out] == 1) {
					nc += costq;
				} else {
					nc += costp;
				}
				
				if(nc < cost[out]) {
					q.offer(new Node(out, nc));
					cost[out] = nc;
				}
			}
		}
	}
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n+1];
		state = new int[n+1];
		
		for(int out : danger) {
			q.offer(new int[] {out, 0});
			state[out] = 2;
			visit[out] = true;
		}
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			
			if(poll[1] == range) continue;
			
			for(int out : list.get(poll[0])) {
				if(visit[out]) continue;
				q.offer(new int[] {out, poll[1]+1});
				visit[out] = true;
				if(state[out] == 0) state[out]++;
			}
		}
	}
	
	public static class Node implements Comparable<Node> {
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
