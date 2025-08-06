package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main_14618_총깡총깡 {
	static final int INF = 1000000000;
	
	static int n, m, j, k;
	static List<List<int[]>> list = new ArrayList<>();
	static int[] cost;
	static Set<Integer> a = new HashSet<>();
	static Set<Integer> b = new HashSet<>();

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();
		
		n = rd.nextInt();
		m = rd.nextInt();
		j = rd.nextInt();
		k = rd.nextInt();
		
		for(int i = 0; i < k; i++) {
			a.add(rd.nextInt());
		}
		
		for(int i = 0; i < k; i++) {
			b.add(rd.nextInt());
		}
		
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
		
		
		dijkstra();
		
		int minA = INF, minB = INF;
		for (int v : a) minA = Math.min(minA, cost[v]);
		for (int v : b) minB = Math.min(minB, cost[v]);

		if (minA == INF && minB == INF) {
		    System.out.println(-1);
		} else if (minA <= minB) {
		    System.out.println("A");
		    System.out.println(minA);
		} else {
		    System.out.println("B");
		    System.out.println(minB);
		}
	}

	private static void dijkstra() {
		Queue<Node> q = new PriorityQueue<>();
		cost = new int[n+1];
		Arrays.fill(cost, INF);
		
		q.offer(new Node(j, 0));
		cost[j] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.w > cost[poll.node]) {
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
