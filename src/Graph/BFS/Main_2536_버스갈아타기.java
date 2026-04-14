package Graph.BFS;

import java.io.*;
import java.util.*;

public class Main_2536_버스갈아타기 {
    static int m, n, k;
    static Bus[] buses;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());
        buses = new Bus[k + 1];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            buses[idx] = new Bus(idx, x1, y1, x2, y2);
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        bfs(sx, sy, dx, dy);
    }

    private static void bfs(int sx, int sy, int dx, int dy) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[k + 1];
        int[] dist = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            if (isInline(sx, sy, buses[i])) {
                q.offer(i);
                visited[i] = true;
                dist[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            Bus now = buses[cur];

            if (isInline(dx, dy, now)) {
                System.out.println(dist[cur]);
                return;
            }

            for (int i = 1; i <= k; i++) {
                if (visited[i]) continue;
                if (isIntersect(now, buses[i])) {
                    visited[i] = true;
                    dist[i] = dist[cur] + 1;
                    q.offer(i);
                }
            }
        }
    }

    private static boolean isInline(int x, int y, Bus b) {
        if (b.sx == b.ex) {
            return x == b.sx && b.sy <= y && y <= b.ey;
        } else {
            return y == b.sy && b.sx <= x && x <= b.ex;
        }
    }

    private static boolean isIntersect(Bus a, Bus b) {
        if (a.sx == a.ex && b.sx == b.ex) {
            if (a.sx != b.sx) return false;
            return !(a.ey < b.sy || b.ey < a.sy);
        }

        if (a.sy == a.ey && b.sy == b.ey) {
            if (a.sy != b.sy) return false;
            return !(a.ex < b.sx || b.ex < a.sx);
        }

        Bus v = (a.sx == a.ex) ? a : b;
        Bus h = (a.sy == a.ey) ? a : b;

        return h.sx <= v.sx && v.sx <= h.ex &&
               v.sy <= h.sy && h.sy <= v.ey;
    }

    static class Bus {
        int idx, sx, sy, ex, ey;

        Bus(int idx, int x1, int y1, int x2, int y2) {
            this.idx = idx;
            this.sx = Math.min(x1, x2);
            this.sy = Math.min(y1, y2);
            this.ex = Math.max(x1, x2);
            this.ey = Math.max(y1, y2);
        }
    }
}