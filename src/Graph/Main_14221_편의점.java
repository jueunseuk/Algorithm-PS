package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main_14221_편의점 {
static final int INF = 1000000000;
	
	static int n, m, h, c;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost;
	static int[] conv;
	static Set<Integer> home = new HashSet<>();

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
		
		h = rd.nextInt();
		c = rd.nextInt();
		for(int i = 0; i < h; i++) {
			home.add(rd.nextInt());
		}
		
		conv = new int[c];
		for(int i = 0; i < c; i++) {
			conv[i] = rd.nextInt();
		}
		
		dijkstra();
		
		int idx = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			if(!home.contains(i) || cost[i] == 0) continue;
			if(cost[i] < min) {
				idx = i;
				min = cost[i];
			}
		}
		
		System.out.println(idx);
	}

	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		cost = new int[n+1];
		Arrays.fill(cost, INF);
		
		for(int out : conv) {
			q.offer(new Node(out, 0));
			cost[out] = 0;
		}
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.w > cost[poll.node] || home.contains(poll.node)) {
				continue;
			}
			
			for(int[] out : list.get(poll.node)) {
				int nc = out[1] + poll.w;
				if(nc < cost[out[0]]) {
					q.offer(new Node(out[0], nc));
					cost[out[0]] = nc;
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int node, w;

		public Node(int node, int w) {
			this.node = node;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
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
