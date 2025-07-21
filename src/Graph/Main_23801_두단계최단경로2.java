package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_23801_두단계최단경로2 {
	static final long INF = 10000000000000l;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static long[] cost1, cost2;
	static int[] candidate;

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
			list.get(end).add(new int[] {start, c});
		}
		
		int x = rd.nextInt();
		int z = rd.nextInt();
		int p = rd.nextInt();
		
		candidate = new int[p];
		for(int i = 0; i < p; i++) {
			candidate[i] = rd.nextInt();
		}
		
		cost1 = new long[n+1];
		dijkstra(x, cost1);
		
		cost2 = new long[n+1];
		dijkstra(z, cost2);
		
		long result = Long.MAX_VALUE;
		for(int out : candidate) {
			if(cost1[out] == INF || cost2[out] == INF) continue;
			result = Long.min(result, cost1[out]+cost2[out]);
		}
		
		System.out.println(result == Long.MAX_VALUE ? -1 : result);
	}

	private static void dijkstra(int start, long[] cost) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(cost, INF);
		
		q.offer(new Node(start, 0));
		cost[start] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.w > cost[poll.node]) continue;
			
			for(int[] out : list.get(poll.node)) {
				long nc = poll.w + (long) out[1];
				if(nc < cost[out[0]]) {
					q.offer(new Node(out[0], nc));
					cost[out[0]] = nc;
				}
			}
		}
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