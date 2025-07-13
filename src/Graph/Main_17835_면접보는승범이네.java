package Graph;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_17835_면접보는승범이네 {
    static final long INF = Long.MAX_VALUE;

    static int n, m, k;
    static List<List<int[]>> list = new ArrayList<>();
    static long[] cost;
    static Queue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();

        n = fr.nextInt();
        m = fr.nextInt();
        k = fr.nextInt();

        cost = new long[n + 1];
        Arrays.fill(cost, INF);

        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int start = fr.nextInt();
            int end   = fr.nextInt();
            int c     = fr.nextInt();
            list.get(end).add(new int[]{start, c});
        }

        for (int i = 0; i < k; i++) {
            int temp = fr.nextInt();
            q.offer(new long[]{temp, 0});
            cost[temp] = 0;
        }

        dijkstra();

        int num = 0;
        long max = 0;
        for (int i = 1; i <= n; i++) {
            if (cost[i] > max) {
                max = cost[i];
                num = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(num).append('\n').append(max);
        System.out.print(sb);
    }

    private static void dijkstra() {
        while (!q.isEmpty()) {
            long[] poll = q.poll();
            int   cur  = (int) poll[0];
            long  dist = poll[1];

            if (dist > cost[cur]) continue;

            for (int[] edge : list.get(cur)) {
                int next = edge[0];
                long nd  = dist + edge[1];
                if (nd < cost[next]) {
                    cost[next] = nd;
                    q.offer(new long[]{next, nd});
                }
            }
        }
    }

    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int idx = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (idx >= len) {
                len = in.read(buffer);
                idx = 0;
                if (len == -1) return -1;
            }
            return buffer[idx++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= 32 && c != -1);
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}