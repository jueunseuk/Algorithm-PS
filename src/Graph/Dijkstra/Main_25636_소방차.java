package Graph.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_25636_소방차 {
	static final long INF = 10000000000000l;
	
	static int n, m;
	static List<List<long[]>> list = new ArrayList<>();
	static long[] cost;
	static long[] inter;
	static long[] water;

	public static void main(String[] args) throws Exception {
		Reader rd = new Reader();

		n = rd.nextInt();
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		inter = new long[n+1];
		for(int i = 1; i <= n; i++) {
			inter[i] = rd.nextInt();
		}
		
		m = rd.nextInt();
		for(int i = 0; i < m; i++) {
			int start = rd.nextInt();
			int end = rd.nextInt();
			int c = rd.nextInt();
			
			list.get(start).add(new long[] {end, c});
			list.get(end).add(new long[] {start, c});
		}
		
		int start = rd.nextInt();
		int end = rd.nextInt();
		
		dijkstra(start, end);
	}

	private static void dijkstra(int start, int end) {
	    Queue<long[]> q = new PriorityQueue<>(new Comparator<long[]>() {
	        @Override
	        public int compare(long[] o1, long[] o2) {
	            if (o1[1] == o2[1]) return Long.compare(o2[2], o1[2]);
	            return Long.compare(o1[1], o2[1]);
	        }
	    });

	    water = new long[n+1];
	    cost = new long[n+1];
	    Arrays.fill(cost, INF);
	    Arrays.fill(water, -1);

	    q.offer(new long[]{start, 0, inter[start]});
	    cost[start] = 0;
	    water[start] = inter[start];

	    while (!q.isEmpty()) {
	        long[] poll = q.poll();
	        int u = (int) poll[0];

	        if (poll[1] > cost[u]) continue;
	        if (poll[1] == cost[u] && poll[2] < water[u]) continue;

	        if (u == end && poll[2] == water[u]) {
	            System.out.println(poll[1]+" "+poll[2]);
	            return;
	        }

	        for (long[] out : list.get(u)) {
	            int v = (int) out[0];
	            long nc = poll[1] + out[1];
	            long nw = poll[2] + inter[v];

	            if (nc < cost[v]) {
	                cost[v] = nc;
	                water[v] = nw;
	                q.offer(new long[]{v, nc, nw});
	            } else if (nc == cost[v] && nw > water[v]) {
	                water[v] = nw;
	                q.offer(new long[]{v, nc, nw});
	            }
	        }
	    }

	    System.out.println(-1);
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
