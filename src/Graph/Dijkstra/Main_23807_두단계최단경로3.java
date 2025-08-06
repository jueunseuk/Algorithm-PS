package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_23807_두단계최단경로3 {
	static final long INF = 1000000000000000000l;
	
	static int n, m;
	static List<List<int[]>> list = new ArrayList<>();
	static long[] costx, costz, cand[];
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
		
		costx = new long[n+1];
		costz = new long[n+1];
		dijkstra(x, costx);
		dijkstra(z, costz);
		
		int p = rd.nextInt();
		candidate = new int[p];
		for(int i = 0; i < p; i++) {
			candidate[i] = rd.nextInt();
		}
		
		cand = new long[p][];
        for (int i = 0; i < p; i++) {
            cand[i] = new long[n + 1];
            dijkstra(candidate[i], cand[i]);
        }

        long ans = INF;
        for (int ia = 0; ia < p; ia++)
            for (int ib = 0; ib < p; ib++) if (ib != ia)
                for (int ic = 0; ic < p; ic++) if (ic != ia && ic != ib) {
                    int A = candidate[ia], B = candidate[ib], C = candidate[ic];
                    long v1 = costx[A] + cand[ia][B] + cand[ib][C] + costz[C];
                    long v2 = costx[A] + cand[ia][C] + cand[ic][B] + costz[B];
                    long v3 = costx[B] + cand[ib][A] + cand[ia][C] + costz[C];
                    long v4 = costx[B] + cand[ib][C] + cand[ic][A] + costz[A];
                    long v5 = costx[C] + cand[ic][A] + cand[ia][B] + costz[B];
                    long v6 = costx[C] + cand[ic][B] + cand[ib][A] + costz[A];
                    
                    long cur = Math.min(Math.min(Math.min(v1, v2), Math.min(v3, v4)), Math.min(v5, v6));
                    
                    if(cur >= INF) continue;
                    
                    if (cur < ans) ans = cur;
                }
		
		System.out.println(ans == INF ? -1 : ans);
	}

	private static void dijkstra(int i, long[] cost) {
		Queue<Node> q = new PriorityQueue<>();
		Arrays.fill(cost, INF);
		
		q.offer(new Node(i, 0));
		cost[i] = 0;
		
		while(!q.isEmpty()) {
			Node poll = q.poll();
			
			if(poll.w > cost[poll.node]) continue;
			
			for(int[] out : list.get(poll.node)) {
				long nc = poll.w + out[1];
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