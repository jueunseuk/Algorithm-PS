package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_34061_소어그래프 {
    static final int L = 1 << 20;
    static int T;
    static int S;

    static int bfs(int start, int goal, int limit) {
        if (start > limit || goal > limit) return -1;
        int[] dist = new int[limit + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            int d = dist[u];

            int v = u ^ T;
            if (v <= limit && dist[v] == -1) {
                dist[v] = d + 1;
                if (v == goal) return dist[v];
                q.add(v);
            }

            v = (u ^ T) + 1;
            if (u != S && v < L && v <= limit && dist[v] == -1) {
                dist[v] = d + 1;
                if (v == goal) return dist[v];
                q.add(v);
            }
        }
        
        return dist[goal];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        S = (L - 1) ^ T;

        long blkX = x / L, blkY = y / L;
        long lastBlk = (N - 1) / L;
        int  lastLim = (int) ((N - 1) - lastBlk * L);

        if (blkX == blkY) {
            int limit = (blkX == lastBlk) ? lastLim : L - 1;
            System.out.println(bfs((int) (x % L), (int) (y % L), limit));
            return;
        }

        int limitX = (blkX == lastBlk) ? lastLim : L - 1;
        int d1 = bfs((int) (x % L), S, limitX);
        if (d1 < 0) { System.out.println(-1); return; }

        int d0 = bfs(0, S, L - 1);
        if (d0 < 0) { System.out.println(-1); return; }

        int limitY = (blkY == lastBlk) ? lastLim : L - 1;
        int d3 = bfs(0, (int) (y % L), limitY);
        if (d3 < 0) { System.out.println(-1); return; }

        long delta = blkY - blkX;
        long ans = (long) d1 + 1 + (delta - 1) * ((long) d0 + 1) + (long) d3;
        
        System.out.println(ans);
    }
}
