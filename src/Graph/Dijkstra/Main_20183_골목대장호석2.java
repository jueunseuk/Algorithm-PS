package Graph.Dijkstra;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main_20183_골목대장호석2 {
    private static final long INF = Long.MAX_VALUE / 4;

    static int n, m, s, e;
    static long budget;
    static List<List<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
    	Reader rd = new Reader();

        n = rd.nextInt();
        m = rd.nextInt();
        s = rd.nextInt();
        e = rd.nextInt();
        budget = rd.nextLong();

        int maxEdge = 0;
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = rd.nextInt();
            int v = rd.nextInt();
            int w = rd.nextInt();

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
            maxEdge = Math.max(maxEdge, w);
        }

        long lo = 0, hi = maxEdge, answer = -1;
        while (lo <= hi) {
            long mid = (lo + hi) >> 1;
            long dist = dijkstra(mid);

            if (dist <= budget) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(answer);
    }

    private static long dijkstra(long limit) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        dist[s] = 0;
        pq.offer(new long[]{s, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int v = (int) cur[0];
            long d = cur[1];

            if (d != dist[v]) continue;
            if (d > budget) return INF;
            if (v == e) return d;

            for (int[] nxt : graph.get(v)) {
                if (nxt[1] > limit) continue;
                long nd = d + nxt[1];
                if (nd < dist[nxt[0]]) {
                    dist[nxt[0]] = nd;
                    pq.offer(new long[]{nxt[0], nd});
                }
            }
        }
        
        return dist[e];
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
	    
	    long nextLong() throws Exception {
	        long val = 0L;
	        byte c;
	        boolean neg = false;
	        while ((c = read()) <= 32);
	        if (c == 45) {
	            neg = true;
	            c = read();
	        }
	        do val = (val << 3) + (val << 1) + (c & 15);
	        while (isnumber(c = read()));
	        return neg ? -val : val;
	    }

	    char nextChar() throws Exception {
	        byte c;
	        while ((c = read()) <= 32);
	        return (char) c;
	    }

	    String nextString() throws Exception {
	        StringBuilder sb = new StringBuilder();
	        byte c;
	        while ((c = read()) <= 32);
	        do sb.append((char) c);
	        while ((c = read()) > 32);
	        return sb.toString();
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