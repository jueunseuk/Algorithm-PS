package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1810_징검다리달리기2 {
	static final int MAX = 1000000;
	static final double INF = 10000000000000000000f;
	
	static int n, finish;
	static List<List<Rock>> list = new ArrayList<>();
	static double[] cost;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		finish = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= MAX; i++) {
			list.add(new ArrayList<>());
		}
		
		int idx = 1;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			Rock curr = new Rock(idx++, x, y);
			
			if(x >= 2) list.get(x-2).add(curr);
			if(x >= 1) list.get(x-1).add(curr);
			list.get(x).add(curr);
			if(x <= 999999) list.get(x+1).add(curr);
			if(x <= 999998) list.get(x+2).add(curr);
		}
		
		dijkstra(0, 0);
	}

	private static void dijkstra(int i, int j) {
		Queue<Node> q = new PriorityQueue<>();
		
		cost = new double[MAX+1];
		Arrays.fill(cost, INF);
		
		q.offer(new Node(0, i, j, 0));
		cost[0] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.y == finish) {
				System.out.println(Math.round(poll.dist));
				return;
			}
			
			if(poll.dist > cost[poll.node]) continue;
			
			for(Rock out : list.get(poll.x)) {
				if (Math.abs(out.y - poll.y) > 2) continue;
				
				double nc = poll.dist + calc(poll.x, poll.y, out.x, out.y);
				if(nc < cost[out.node]) {
					q.offer(new Node(out.node, out.x, out.y, nc));
					cost[out.node] = nc;
				}
			}
		}
		
		System.out.println(-1);
	}

	private static double calc(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
	
	public static class Node implements Comparable<Node> {
		int node, x, y;
		double dist;
		
		public Node(int node, int x, int y, double dist) {
			this.node = node;
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.dist, o.dist);
		}
	}
	
	public static class Rock {
		int node, x, y;

		public Rock(int node, int x, int y) {
			this.node = node;
			this.x = x;
			this.y = y;
		}
	}
}