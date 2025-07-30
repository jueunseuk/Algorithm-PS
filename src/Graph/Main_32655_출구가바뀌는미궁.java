package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_32655_출구가바뀌는미궁 {
	static final long INF = Long.MAX_VALUE/4;
	
	static int n, m, k, x;
	static List<List<int[]>> list = new ArrayList<>();
	static long[] cost;
	static int[] exit;

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		n = rd.nextInt();
		m = rd.nextInt();
		k = rd.nextInt();
		
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
		
		x = rd.nextInt();
		exit = new int[x];
		for(int i = 0; i < x; i++) {
			exit[i] = rd.nextInt();
		}
		
		dijkstra();
	}

	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		cost = new long[n+1];
		Arrays.fill(cost, INF);
		
		q.offer(new Node(1, 0));
		cost[1] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			
			
			for(int[] out : list.get(poll.node)) {
				long nc = out[1] + poll.w;
				if(nc < cost[out[0]]) {
					q.offer(new Node(out[0], nc));
				}
				
				nc += k - poll.w % k;
				if(nc < cost[out[0]]) {
					q.offer(new Node(out[0], nc));
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
			return Long.compare(this.w, o.node);
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
