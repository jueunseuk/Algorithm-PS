package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_23793_두단계최단경로1 {
	static final int INF = 1000000000;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost1, cost2, cost3;

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		n = rd.nextInt();
		m = rd.nextInt();
		
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			int start = rd.nextInt();
			int end = rd.nextInt();
			int c = rd.nextInt();
			
			list.get(start).add(new int[] {end, c});
		}
		
		int x = rd.nextInt();
		int y = rd.nextInt();
		int z = rd.nextInt();
		
		cost1 = new int[n+1];
		xtoz(x, y, z);
		
		cost2 = new int[n+1];
		xtoy(x, y);
		
		cost3 = new int[n+1];
		ytoz(y, z);
		
		StringBuilder sb = new StringBuilder();
		int result1 = cost2[y] + cost3[z];
		if(cost2[y] == INF || cost3[z] == INF) {
			result1 = INF;
		}
		int result2 = cost1[z];
		
		sb.append(result1 == INF ? -1 : result1).append(" ").append(result2 == INF ? -1 : result2);
		System.out.println(sb.toString().trim());
	}

	private static void xtoz(int start, int nope, int end) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(cost1, INF);
		
		q.offer(new Node(start, 0));
		cost1[start] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.node == end) {
				return;
			}
			
			if(poll.w > cost1[poll.node]) continue;
			
			for(int[] out : list.get(poll.node)) {
				if(out[0] == nope) continue;
				int nc = poll.w + out[1];
				if(nc < cost1[out[0]]) {
					q.offer(new Node(out[0], nc));
					cost1[out[0]] = nc;
				}
			}
		}
	}
	
	private static void xtoy(int start, int end) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(cost2, INF);
		
		q.offer(new Node(start, 0));
		cost2[start] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.node == end) {
				return;
			}
			
			if(poll.w > cost2[poll.node]) continue;
			
			for(int[] out : list.get(poll.node)) {
				int nc = poll.w + out[1];
				if(nc < cost2[out[0]]) {
					q.offer(new Node(out[0], nc));
					cost2[out[0]] = nc;
				}
			}
		}
	}
	
	private static void ytoz(int start, int end) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(cost3, INF);
		
		q.offer(new Node(start, 0));
		cost3[start] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.node == end) {
				return;
			}
			
			if(poll.w > cost3[poll.node]) continue;
			
			for(int[] out : list.get(poll.node)) {
				int nc = poll.w + out[1];
				if(nc < cost3[out[0]]) {
					q.offer(new Node(out[0], nc));
					cost3[out[0]] = nc;
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int node;
		int w;
		
		public Node(int node, int w) {
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static class Reader {
	    private final int SIZE = 1 << 13;
	    private byte[] buffer = new byte[SIZE];
	    private int index, size;
	    
	    int nextInt() throws Exception {
	        int lis = 0;
	        byte c;
	        boolean isMinus = false;
	        while ((c = read()) <= 32);
	        if (c == 45) { c = read(); isMinus = true; }
	        do lis = (lis << 3) + (lis << 1) + (c & 15);
	        while (isnumber(c = read()));
	        return isMinus ? ~lis + 1 : lis;
	    }

	    private boolean isnumber(byte c) {
	        return 47 < c && c < 58;
	    }

	    private byte read() throws Exception {
	        if (index == size) {
	            size = System.in.read(buffer, index = 0, SIZE);
	            if (size < 0) buffer[0] = -1;
	        }
	        return buffer[index++];
	    }
	}
}